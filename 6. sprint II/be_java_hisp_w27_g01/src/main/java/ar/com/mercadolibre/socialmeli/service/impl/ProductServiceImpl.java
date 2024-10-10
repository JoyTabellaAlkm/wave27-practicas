package ar.com.mercadolibre.socialmeli.service.impl;

import ar.com.mercadolibre.socialmeli.dto.request.ActivatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.CreatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.PostRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.Product;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.IRepository;
import ar.com.mercadolibre.socialmeli.service.IProductService;
import ar.com.mercadolibre.socialmeli.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

   private final IRepository repository;

    public ProductServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostOkResponseDTO createPost(PostRequestDTO postRequestDTO) {

        if (postRequestDTO == null) {
            throw new BadRequestException("PublicationDTO is null");
        }

        if (!repository.existId(postRequestDTO.getUserId())){
            throw new BadRequestException("User ID: " + postRequestDTO.getUserId() + " doesn´t exist.");
        }

        User userPost = repository.getUserById(postRequestDTO.getUserId());
        Integer id = userPost.getPosts().stream().mapToInt(Post::getPostId).max().orElse(0) + 1;
        Post post = Utils.changeDtoToEntity(postRequestDTO, Post.class);
        post.setPostId(id);

        post.setHasPromo(false);
        post.setDiscount(0.0);

        boolean isOk = repository.addPostToUser(userPost, post);

        if (!isOk) {
            throw new BadRequestException("Post already exists");
        }

        return new PostOkResponseDTO("OK");
    }

    @Override
    public CreatePromoResponseDTO createPromoPost(CreatePromoRequestDTO requestDto) {

        if (!repository.existId(requestDto.getUserId())) {
            throw new BadRequestException("User ID: " + requestDto.getUserId() + " doesn´t exist.");
        }

        User user = repository.getUserById(requestDto.getUserId());

        Post post = new Post();
        post.setProduct(Utils.changeDtoToEntity(
                requestDto.getProduct(), Product.class));
        post.setCategory(requestDto.getCategory());
        post.setPrice(requestDto.getPrice());
        post.setDate(requestDto.getDate());
        post.setHasPromo(requestDto.isHasPromo());
        post.setDiscount(requestDto.getDiscount());

        Integer createdId = repository.createPost(user, post);

        CreatePromoResponseDTO responseDto = new CreatePromoResponseDTO();
        responseDto.setCreatedId(createdId);

        return responseDto;
    }

    @Override
    public FollowersListResponseDTO getRecentPostFromFollowedUsers(Integer userId, String order) {
        if (!repository.existId(userId)) {
            throw new BadRequestException("User ID: " + userId + " doesn´t exist.");
        }

        User user = repository.getUserById(userId);
        List<Integer> followedIds = user.getFollowedIds();

        if (followedIds == null || followedIds.isEmpty()) {
            throw new BadRequestException("User ID: " + userId + " is not following anyone.");
        }

        if (order != null && !order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc")) {
            throw new BadRequestException("Invalid order parameter: " + order);
        }

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        List<PostDetailsResponseDTO> recentPost = repository.getUsers().stream()
                .filter(u -> followedIds.contains(u.getUserId()))
                .flatMap(u -> u.getPosts().stream()
                        .filter(post -> post.getDate().isAfter(twoWeeksAgo))
                        .map(post -> new PostDetailsResponseDTO(u.getUserId(), post.getPostId(), post.getDate(), Utils.changeEntityToDTO(post.getProduct(), ProductResponseDTO.class), post.getCategory(), post.getPrice())))
                .sorted(order != null && order.equalsIgnoreCase("date_desc") ?
                Comparator.comparing(PostDetailsResponseDTO::getDate).reversed() :
                Comparator.comparing(PostDetailsResponseDTO::getDate))
                .collect(Collectors.toList());

        if (recentPost.isEmpty()) {
            throw new BadRequestException("There aren't posts of minus two weeks.");
        }

        return new FollowersListResponseDTO(userId, recentPost);
    }


    @Override
    public ProductPromoCountResponseDTO getPromoProductsCountBySeller(Integer userId) {

        if (!repository.existId(userId)){
            throw new NotFoundException("User ID: " + userId + " doesn´t exist.");
        }

        User user = repository.getUserById(userId);

        Integer promoCount = Integer.parseInt(String.valueOf(user.getPosts().stream()
                .filter(Post::getHasPromo)
                .count()));

        return new ProductPromoCountResponseDTO(user.getUserId(), user.getUserName(), promoCount);
    }

    @Override
    public List<PostDetailsResponseDTO> searchPostsByDate(LocalDate dateStart, LocalDate dateEnd) {

        if (dateStart == null) {
            throw new BadRequestException("Start date cannot be null");
        }

        if (dateEnd == null) {
            dateEnd = LocalDate.now();
        }

        LocalDate finalDateEnd = dateEnd;

        return repository.getUsers().stream()
                .flatMap(user -> user.getPosts().stream()
                        .filter(post -> !post.getDate().isBefore(dateStart) && !post.getDate().isAfter(finalDateEnd))
                        .map(post -> new PostDetailsResponseDTO(user.getUserId(), post.getPostId(), post.getDate(), Utils.changeEntityToDTO(post.getProduct(), ProductResponseDTO.class), post.getCategory(), post.getPrice())))
                .collect(Collectors.toList());
    }
  
    public PostOkResponseDTO deletePost(Integer userId, Integer postId){

        if (!repository.existId(userId)){
            throw new NotFoundException("User ID: " + userId + " doesn´t exist.");
        }

        User user = repository.getUserById(userId);
        Post postFind = user.getPosts().stream()
                .filter(post -> post.getPostId().equals(postId)).findFirst().orElse(null);

        if(postFind == null){
            throw new NotFoundException("Post ID: " + postId + " doesn´t exist.");
        }

        repository.removePost(postFind);

        return new PostOkResponseDTO("OK");
    }

    public List<SearchResponseDTO> searchPostByBrandAndName(String query, Integer userId) {
        if (userId != null && !repository.existId(userId)){
            throw new NotFoundException("User ID: " + userId + " doesn´t exist.");
        }

        
        List<User> usuarios = repository.getUsers();

        if(userId != null){
            usuarios = usuarios.stream().filter(u -> u.getUserId().equals(userId)).findFirst().stream().toList();
        }

        return usuarios.stream()
                .flatMap(user -> user.getPosts().stream()
                        .filter(post -> compareQuery(post.getProduct().getProductName(), query) || compareQuery(post.getProduct().getBrand(), query))
                        .map(post -> new SearchResponseDTO(post.getPostId(), Utils.changeEntityToDTO(post.getProduct(), ProductResponseDTO.class), post.getDate(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount(), user.getUserId())))
                .toList();
    }

    private Boolean compareQuery(String str, String query){
        return Utils.removeAccents(str).toLowerCase().contains(Utils.removeAccents(query).toLowerCase());
    }

    public ProductPostsHistoryResponseDTO getSellerPostListHistory(Integer userId, Boolean withPromo) {
        if (userId == null || userId <= 0) {
            throw new BadRequestException("User ID: " + userId + " is invalid.");
        }

        if (!repository.existId(userId)) {
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        User user = repository.getUserById(userId);

        if (user.getPosts().isEmpty()) {
            throw new BadRequestException("User ID: " + userId + " doesn't have posts.");
        }

        List<PostResponseDTO> postsDTO = user.getPosts().stream()
                .filter(post -> withPromo == null || post.getHasPromo().equals(withPromo))
                .map(post -> new PostResponseDTO(post.getPostId(), post.getDate(), Utils.changeEntityToDTO(post.getProduct(), ProductResponseDTO.class), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount()))
                .toList();

        return new ProductPostsHistoryResponseDTO(user.getUserId(), user.getUserName(), postsDTO);
    }

    public PostOkResponseDTO activatePromo(ActivatePromoRequestDTO promo){

        validatePromoRequest(promo);

        User user = repository.getUserById(promo.getUserId());

        Post post = user.getPosts().stream()
                .filter(p -> p.getPostId().equals(promo.getPostId()))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Post ID: " + promo.getPostId() + " doesn´t exist."));

        post.setHasPromo(true);
        post.setDiscount(promo.getDiscount());

        repository.updatePost(user, post);

        return new PostOkResponseDTO("OK");
    }

    private void validatePromoRequest(ActivatePromoRequestDTO promo) {

        if (!repository.existId(promo.getUserId())) {
            throw new BadRequestException("User ID: " + promo.getUserId() + " doesn´t exist.");
        }
    }
}