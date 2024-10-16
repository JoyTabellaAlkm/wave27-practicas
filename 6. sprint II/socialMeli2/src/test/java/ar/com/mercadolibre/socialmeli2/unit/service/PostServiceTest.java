package ar.com.mercadolibre.socialmeli2.unit.service;

import ar.com.mercadolibre.socialmeli2.dto.requests.ProductDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.FollowedPostDto;
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
import ar.com.mercadolibre.socialmeli2.service.impl.PostServiceImpl;
import ar.com.mercadolibre.socialmeli2.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    private IPostRepository postRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IFollowRepository followRepository;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    private List<User> sellers;
    private List<Follow> follows;
    private User user;
    private List<Post> seller0Posts;
    private List<Post> seller1Posts;
    private List<Post> seller2Posts;

    @BeforeEach
    public void setUp() {
        follows = TestUtils.createUserFollows();
        user = follows.get(0).getUser();

        sellers = follows.stream()
                .map(Follow::getUserToFollow)
                .toList();
    }

    @Test
    @DisplayName("T-0005 - WRONG ORDER")
    public void getPostsFromFollowedOrdersThrowsValidationException() {
        // Arrange
        createPostLists();

        // Act & Assert
        when(userRepository.existsById(user.getId())).thenReturn(true);
        setupTest6Mocks();
        assertThrows(ValidationException.class, () -> postService.getPostsFromFollowed(user.getId(), "date"));
    }

    @Test
    @DisplayName("T-0005 // T-0006 // T-0008 - ASC")
    public void getPostsFromFollowedOrdersAscTest() {
        // Arrange
        createPostLists();

        // Act
        when(userRepository.existsById(user.getId())).thenReturn(true);
        setupTest6Mocks();
        UserFollowedPostsDto result = postService.getPostsFromFollowed(user.getId(), "date_asc");

        // Assert
        assertEquals(user.getId(), result.getUserId());
        assertEquals(5, result.getPosts().size());
        assertEquals(2, result.getPosts().get(0).getPostId());
        assertEquals(1, result.getPosts().get(4).getPostId());
    }

    @Test
    @DisplayName("T-0005 // T-0006 // T-0008 - DESC")
    public void getPostsFromFollowedOrdersDescTest() {
        // Arrange
        createPostLists();

        // Act
        when(userRepository.existsById(user.getId())).thenReturn(true);
        setupTest6Mocks();
        UserFollowedPostsDto result = postService.getPostsFromFollowed(user.getId(), "date_desc");

        // Assert
        assertEquals(user.getId(), result.getUserId());
        assertEquals(5, result.getPosts().size());
        assertEquals(1, result.getPosts().get(0).getPostId());
        assertEquals(2, result.getPosts().get(4).getPostId());
    }

    @Test
    @DisplayName("T-0006 // T-0008 - NO ORDER")
    public void getPostsFromFollowedOrdersDefaultTest() {
        // Arrange
        createPostLists();

        // Act
        when(userRepository.existsById(user.getId())).thenReturn(true);
        setupTest6Mocks();
        UserFollowedPostsDto result = postService.getPostsFromFollowed(user.getId(), null);

        // Assert
        assertEquals(user.getId(), result.getUserId());
        assertEquals(5, result.getPosts().size());
        assertEquals(1, result.getPosts().get(0).getPostId());
        assertEquals(2, result.getPosts().get(4).getPostId());
    }

    @Test
    @DisplayName("T-0006 - USER NOT FOUND")
    public void getPostsFromFollowedOrdersThrowsUserNotFound() {
        // Arrange
        int nonexistentUserId = 99;

        // Act & Assert
        when(userRepository.existsById(nonexistentUserId)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> postService.getPostsFromFollowed(nonexistentUserId, "date_asc"));
    }

    private void createPostLists() {
        seller0Posts = List.of(
                new Post(1, sellers.get(0), new Product(), LocalDate.now(), 0.0, false, 0.0),
                new Post(2, sellers.get(0), new Product(), LocalDate.now().minusWeeks(1), 0.0, false, 0.0)
        );

        seller1Posts = List.of(
                new Post(3, sellers.get(1), new Product(), LocalDate.now().minusDays(2), 0.0, false, 0.0),
                new Post(4, sellers.get(1), new Product(), LocalDate.now().minusDays(3), 0.0, false, 0.0)
        );

        seller2Posts = List.of(
                new Post(5, sellers.get(2), new Product(), LocalDate.now().minusDays(1), 0.0, false, 0.0),
                new Post(6, sellers.get(2), new Product(), LocalDate.now().minusWeeks(4), 0.0, false, 0.0)
        );
    }

    private void setupTest6Mocks() {
        when(followRepository.findFollowsByFollowerId(user.getId()))
                .thenReturn(follows.stream().filter(follow -> follow.getUser().getId() == user.getId()).toList());
        when(postRepository.findByUserId(sellers.get(0).getId())).thenReturn(seller0Posts);
        when(postRepository.findByUserId(sellers.get(1).getId())).thenReturn(seller1Posts);
        when(postRepository.findByUserId(sellers.get(2).getId())).thenReturn(seller2Posts);
        when(modelMapper.map(any(), eq(FollowedPostDto.class))).thenAnswer(invocation -> {
            Post post = invocation.getArgument(0);
            return new FollowedPostDto(post.getUser().getId(), post.getId(), post.getDate(), new ProductDto(), 0, 0.0);
        });
    }
}
