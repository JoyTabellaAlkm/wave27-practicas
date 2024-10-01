package ar.com.mercadolibre.socialmeli.service.impl;

import ar.com.mercadolibre.socialmeli.dto.request.ActivatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.CreatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.PostRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.IRepository;
import ar.com.mercadolibre.socialmeli.service.IProductService;
import ar.com.mercadolibre.socialmeli.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

   private IRepository repository;

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
        Post post = Utils.changePostDtoToEntity(postRequestDTO);
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
        post.setProduct(requestDto.getProduct());
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
    public PostFollowersListResponseDTO getRecentPostFromFollowedUsers(Integer userId, String order) {

        if (!repository.existId(userId)) {
            throw new BadRequestException("User ID: " + userId + " doesn´t exist.");
        }

        User user = repository.getUserById(userId);

        List<Integer> followedIds = user.getFollowedIds();

        if (followedIds == null || followedIds.isEmpty()) {
            throw new BadRequestException("User ID: " + userId + " is not following anyone.");
        }

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        List<PostIdResponseDTO> recentPost = repository.getUsers().stream()
                .filter(u -> followedIds.contains(u.getUserId()))
                .flatMap(u -> u.getPosts().stream().map(post -> new PostIdResponseDTO(u.getUserId(), post.getPostId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice())))
                .filter(postDTO -> postDTO.getDate().isAfter(twoWeeksAgo))
                .toList();

        if (recentPost.isEmpty()) {
            throw new BadRequestException("There aren't posts of minus two weeks.");
        }

        if (order != null) {
            if (order.equalsIgnoreCase("date_asc")) {
                recentPost = recentPost.stream()
                        .sorted(Comparator.comparing(PostIdResponseDTO::getDate))
                        .collect(Collectors.toList());
            } else if (order.equalsIgnoreCase("date_desc")) {
                recentPost = recentPost.stream()
                        .sorted(Comparator.comparing(PostIdResponseDTO::getDate).reversed())
                        .collect(Collectors.toList());
            }
        }

        return new PostFollowersListResponseDTO(userId, recentPost);
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
    public List<PostIdResponseDTO> searchPostsByDate(LocalDate dateStart, LocalDate dateEnd) {

        if (dateStart == null) { throw new BadRequestException("Start date cannot be null");}

        if (dateEnd == null) { dateEnd = LocalDate.now();}

        List<PostIdResponseDTO> postsIdResponseDTOS = new ArrayList<>();
        
        LocalDate finalDateEnd = dateEnd;

        repository.getUsers().stream()
                .filter(user -> !user.getPosts().isEmpty())
                .forEach(user -> {
                    List<PostIdResponseDTO> userPosts = user.getPosts().stream()
                            .filter(post -> (post.getDate().isAfter(dateStart) || post.getDate().isEqual(dateStart)) && (post.getDate().isBefore(finalDateEnd) || post.getDate().isEqual(finalDateEnd)))
                            .map(post -> new PostIdResponseDTO( user.getUserId(), post.getPostId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice()))
                            .toList();
                    postsIdResponseDTOS.addAll(userPosts);
                });
        return postsIdResponseDTOS;
    }
  
    public PostOkResponseDTO deletePost(Integer userId, Integer postId){

        if (!repository.existId(userId)){
            throw new NotFoundException("User ID: " + userId + " doesn´t exist.");
        }

        User user = repository.getUserById(userId);
        Post postFind = user.getPosts().stream().filter(post -> post.getPostId().equals(postId)).findFirst().orElse(null);
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
                        .map(post -> new SearchResponseDTO(post.getPostId(), post.getProduct(), post.getDate(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount(), user.getUserId())))
                .toList();

     
    }

    private Boolean compareQuery(String str, String query){
        return Utils.removeAccents(str).toLowerCase().contains(Utils.removeAccents(query).toLowerCase());
    }

    public ProductPostsHistoryResponseDTO getSellerPostListHistory(Integer userId, Boolean withPromo) {

        if(userId == null|| userId <= 0){
            throw new BadRequestException("User ID: " + userId + " is invalid.");
        }

        if(!repository.existId(userId)){
            throw new BadRequestException("User ID: " + userId + " doesn't exist.");
        }

        User user = repository.getUserById(userId);

        if(user.getPosts().isEmpty()){
            throw new BadRequestException("User ID: " + userId + " doesn't has Posts.");
        }

        List<Post> posts = user.getPosts();
        List<PostResponseDTO> postsDTO;

        if (Boolean.TRUE.equals(withPromo)) {
            postsDTO = posts.stream()
                    .filter(post -> Boolean.TRUE.equals(post.getHasPromo()))
                    .map(post -> new PostResponseDTO(post.getPostId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount()))
                    .toList();
            return new ProductPostsHistoryResponseDTO(user.getUserId(), user.getUserName(), postsDTO);
        }
        
        if (Boolean.FALSE.equals(withPromo)) {
            postsDTO = posts.stream()
                    .filter(post -> Boolean.FALSE.equals(post.getHasPromo()))
                    .map(post -> new PostResponseDTO(post.getPostId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount()))
                    .toList();
            return new ProductPostsHistoryResponseDTO(user.getUserId(), user.getUserName(), postsDTO);
        }
        
        postsDTO = posts.stream()
                    .map(post -> new PostResponseDTO(post.getPostId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount()))
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
        if (promo.getUserId() == null || promo.getPostId() == null || promo.getDiscount() == null) {
            throw new BadRequestException("User_id, Post_id, and Discount must not be null");
        }

        if (promo.getDiscount() >= 0.51) {
            throw new BadRequestException("Discount cannot be higher than 50%");
        }

        if (!repository.existId(promo.getUserId())) {
            throw new BadRequestException("User ID: " + promo.getUserId() + " doesn´t exist.");
        }
    }
}