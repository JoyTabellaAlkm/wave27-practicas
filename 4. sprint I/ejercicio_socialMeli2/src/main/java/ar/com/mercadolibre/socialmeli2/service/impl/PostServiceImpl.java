package ar.com.mercadolibre.socialmeli2.service.impl;

import ar.com.mercadolibre.socialmeli2.dto.*;
import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.Post;
import ar.com.mercadolibre.socialmeli2.entity.Product;
import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli2.exception.ValidationException;
import ar.com.mercadolibre.socialmeli2.repository.IFollowRepository;
import ar.com.mercadolibre.socialmeli2.repository.IPostRepository;
import ar.com.mercadolibre.socialmeli2.repository.IUserRepository;
import ar.com.mercadolibre.socialmeli2.service.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IFollowRepository followRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository, IFollowRepository followRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public PostDto addPost(PostDto postDto) {
        validatePostDto(postDto);
        Post post = modelMapper.map(postDto, Post.class);

        if (createPost(postDto.getUserId(), postDto.getProductDto(), post)) {
            postRepository.save(post);
        }
        return postDto;
    }

    @Override
    public PromoPostDto addPromoPost(PromoPostDto promoPostDto) {
        validatePromoPostDto(promoPostDto);
        Post post = modelMapper.map(promoPostDto, Post.class);

        if (createPost(promoPostDto.getUserId(), promoPostDto.getProductDto(), post)) {
            postRepository.save(post);
        }
        return promoPostDto;
    }

    private List<FollowedPostDto> orderByDate(List<FollowedPostDto> posts, String order) {
        if(order.equalsIgnoreCase("date_asc")){
            return posts.stream().sorted(Comparator.comparing(FollowedPostDto::getDate)).toList();
        } else if (order.equalsIgnoreCase("date_desc")) {
            return posts.stream().sorted(Comparator.comparing(FollowedPostDto::getDate).reversed()).toList();
        } else {
            throw new ValidationException("Cannot order by " + order);
        }
    }

    @Override
    public UserFollowedPostsDto getPostsFromFollowed(int userId, String order) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User " + userId + " not found");
        }

        List<User> followedUsers = followRepository.findFollowsByFollowerId(userId).stream()
                .map(Follow::getUserToFollow)
                .toList();

        List<FollowedPostDto> posts = followedUsers.stream()
                .map(User::getId)
                .flatMap(id -> postRepository.findByUserId(id).stream())
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .map(post -> modelMapper.map(post, FollowedPostDto.class))
                .toList();

        if(order != null){
            posts = orderByDate(posts, order);
        }

        return new UserFollowedPostsDto(userId, posts);
    }

    private boolean createPost(int userId, ProductDto productDto, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User " + userId + " not found"));

        Product product = modelMapper.map(productDto, Product.class);
        post.setProduct(product);
        user.setSeller(true);
        post.setUser(user);
        post.setId(postRepository.nextId());

        return true;
    }

    @Override
    public PromoCountDto getPromoPostCount(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User " + userId + " not found"));

        if (!user.isSeller()) {
            throw new ValidationException("User " + userId + " is not a seller");
        }

        int count = (int) postRepository.findByUserId(userId)
                .stream()
                .filter(Post::isHasPromo)
                .count();

        return new PromoCountDto(userId, user.getUsername(), count);
    }
    private void validatePostDto(PostDto postDto) {
        if (postDto == null) {
            throw new ValidationException("Post cannot be empty");
        }
        if (postDto.getUserId() <= 0) {
            throw new ValidationException("Invalid user ID");
        }
        if (postDto.getDate() == null) {
            throw new ValidationException("Date cannot be empty");
        }
        if (postDto.getCategory() <= 0) {
            throw new ValidationException("Invalid category");
        }
        if (postDto.getPrice() <= 0) {
            throw new ValidationException("Price must be greater than zero");
        }
        if (postDto.getProductDto() == null) {
            throw new ValidationException("Product cannot be empty");
        }
    }

    private void validatePromoPostDto(PromoPostDto promoPostDto) {
        if (promoPostDto == null) {
            throw new ValidationException("Post cannot be empty");
        }
        if (promoPostDto.getUserId() <= 0) {
            throw new ValidationException("Invalid user ID");
        }
        if (promoPostDto.getDate() == null) {
            throw new ValidationException("Date cannot be empty");
        }
        if (promoPostDto.getCategory() <= 0) {
            throw new ValidationException("Invalid category");
        }
        if (promoPostDto.getPrice() <= 0) {
            throw new ValidationException("Price must be greater than zero");
        }
        if (promoPostDto.getProductDto() == null) {
            throw new ValidationException("Product cannot be empty");
        }
        if (!promoPostDto.isHasPromo()) {
            throw new ValidationException("HasPromo cannot be false");
        }
        if (promoPostDto.getDiscount() <= 0) {
            throw new ValidationException("Discount cannot be zero");
        }
    }
}
