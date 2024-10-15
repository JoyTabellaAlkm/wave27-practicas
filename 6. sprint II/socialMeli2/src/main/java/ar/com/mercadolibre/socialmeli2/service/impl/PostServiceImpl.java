package ar.com.mercadolibre.socialmeli2.service.impl;

import ar.com.mercadolibre.socialmeli2.dto.requests.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.ProductDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.PromoPostDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.FollowedPostDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.PromoCountDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.UserFollowedPostsDto;
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

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository, IFollowRepository followRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        createPost(postDto.getUserId(), postDto.getProduct(), post);
        postRepository.save(post);
        return postDto;
    }

    @Override
    public PromoPostDto addPromoPost(PromoPostDto promoPostDto) {
        Post post = modelMapper.map(promoPostDto, Post.class);
        createPost(promoPostDto.getUserId(), promoPostDto.getProduct(), post);
        postRepository.save(post);
        return promoPostDto;
    }

    private List<FollowedPostDto> orderByDate(List<FollowedPostDto> posts, String order) {
        if (order.equalsIgnoreCase("date_asc")) {
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

        if (order != null) {
            posts = orderByDate(posts, order);
        }

        return new UserFollowedPostsDto(userId, posts);
    }

    private void createPost(int userId, ProductDto productDto, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User " + userId + " not found"));

        Product product = modelMapper.map(productDto, Product.class);
        post.setProduct(product);
        post.setUser(user);
        post.setId(postRepository.nextId());

        if (!user.isSeller()) {
            user.setSeller(true);
        }
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


}
