package ar.com.mercadolibre.socialmeli2.unit.service;

import ar.com.mercadolibre.socialmeli2.dto.responses.FollowDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.FollowersCountDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.UserFollowedDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.UserWithFollowersDto;
import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.exception.ValidationException;
import ar.com.mercadolibre.socialmeli2.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli2.repository.IFollowRepository;
import ar.com.mercadolibre.socialmeli2.repository.IPostRepository;
import ar.com.mercadolibre.socialmeli2.repository.IUserRepository;
import ar.com.mercadolibre.socialmeli2.service.impl.UserServiceImpl;
import ar.com.mercadolibre.socialmeli2.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;
    @Mock
    private IFollowRepository followRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private List<Follow> follows;
    private User user;

    @BeforeEach
    public void setUp() {
        follows = TestUtils.createUserFollows();
        user = follows.get(0).getUser();
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWERS ALPHABETICAL ORDER NAME-ASC")
    public void getFollowersAlphabeticalOrderAsc() {
        // Arrange
        String order = "name_asc";
        user.setSeller(true);

        // Act & Assert
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowedId(user.getId())).thenReturn(follows);
        when(modelMapper.map(any(), eq(UserWithFollowersDto.class))).thenAnswer(invocation -> {
            User mappedUser = invocation.getArgument(0);
            return new UserWithFollowersDto(mappedUser.getId(), mappedUser.getUsername(), List.of());
        });

        assertDoesNotThrow(() -> userService.findAllFollowers(user.getId(), order));
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWERS ALPHABETICAL ORDER NAME-DESC")
    public void getFollowersAlphabeticalOrderDesc() {
        // Arrange
        String order = "name_desc";
        user.setSeller(true);

        // Act & Assert
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowedId(user.getId())).thenReturn(follows);
        when(modelMapper.map(any(), eq(UserWithFollowersDto.class))).thenAnswer(invocation -> {
            User mappedUser = invocation.getArgument(0);
            return new UserWithFollowersDto(mappedUser.getId(), mappedUser.getUsername(), List.of());
        });

        assertDoesNotThrow(() -> userService.findAllFollowers(user.getId(), order));
    }

    @Test
    @DisplayName("T0002 - UNFOLLOW USER")
    public void unfollowUserShoulBeOk() {
        //Arrange
        User userFollowed = new User(1, "UsuarioSeguido", true);
        User userFollower = new User(2, "UsuarioSeguidor", false);
        Follow followExpected = new Follow(userFollowed, userFollower);

        //Act
        when(userRepository.findById(userFollowed.getId())).thenReturn(Optional.of(userFollowed));
        when(userRepository.findById(userFollower.getId())).thenReturn(Optional.of(userFollower));
        when(followRepository.isFollowing(userFollowed.getId(), userFollower.getId())).thenReturn(true);
        when(followRepository.unfollowUser(followExpected)).thenReturn(true);
        FollowDto unfollowResult = userService.unfollowUser(userFollowed.getId(), userFollower.getId());

        //Assert
        assertEquals(userFollowed.getId(), unfollowResult.getUserId());
        assertEquals(userFollower.getId(), unfollowResult.getUserIdToFollow());
    }

    @Test
    @DisplayName("T-0002 - USER TO UNFOLLOW NOT FOUND")
    public void unfollowUserToUnfollowThrowsNotFoundException() {
        // Arrange
        User user = new User(30, "Soledad");
        User userToUnfollow = new User(40, "Maria");

        //Act & Assert
        when(userRepository.findById(30)).thenReturn(Optional.of(user));
        when(userRepository.findById(40)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            userService.unfollowUser(user.getId(), userToUnfollow.getId());
        });
        assertEquals("User " + userToUnfollow.getId() + " not found", exception.getMessage());
    }

    @Test
    @DisplayName("T-0002 - USER NOT FOUND")
    public void unfollowUserThrowsNotFoundException() {
        // Arrange
        User user = new User(30, "Soledad");
        User userToUnfollow = new User(40, "Maria");

        //Act & Assert
        when(userRepository.findById(30)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            userService.unfollowUser(user.getId(), userToUnfollow.getId());
        });
        assertEquals("User " + user.getId() + " not found", exception.getMessage());
    }

    @Test
    @DisplayName("T-0002 - USER DOES NOT FOLLOW")
    public void unfollowUserDoesNotFollowException() {
        // Arrange
        User userFollowed = new User(30, "Soledad");
        User userToUnfollow = new User(40, "Maria");

        //Act & Assert
        when(userRepository.findById(30)).thenReturn(Optional.of(userFollowed));
        when(userRepository.findById(40)).thenReturn(Optional.of(userToUnfollow));
        when(followRepository.isFollowing(userFollowed.getId(), userToUnfollow.getId())).thenReturn(false);
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            userService.unfollowUser(userFollowed.getId(), userToUnfollow.getId());
        });
        assertEquals("User " + userFollowed.getId() + " does not follow user " + userToUnfollow.getId(), exception.getMessage());
    }

    @Test
    @DisplayName("T-0004 - FOLLOWERS ASC")
    public void findAllFollowersSortsAsc() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User followedUser = follows.get(0).getUserToFollow();

        // Act
        when(userRepository.findById(followedUser.getId())).thenReturn(Optional.of(followedUser));
        when(modelMapper.map(eq(followedUser), eq(UserWithFollowersDto.class)))
                .thenReturn(new UserWithFollowersDto(followedUser.getId(), followedUser.getUsername(), null));
        when(followRepository.findFollowsByFollowedId(followedUser.getId()))
                .thenReturn(follows.stream().filter(follow -> follow.getUserToFollow().getId() == followedUser.getId()).toList());

        UserWithFollowersDto result = userService.findAllFollowers(followedUser.getId(), "name_asc");

        // Assert
        assertEquals(followedUser.getId(), result.getUserId());
        assertEquals(2, result.getFollowers().size());
        assertEquals("Ana Rodriguez", result.getFollowers().get(0).getUsername());
        assertEquals("Pedro Gomez", result.getFollowers().get(1).getUsername());
    }

    @Test
    @DisplayName("T-0004 - FOLLOWERS DESC")
    public void findAllFollowersSortsDesc() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User followedUser = follows.get(0).getUserToFollow();

        // Act
        when(userRepository.findById(followedUser.getId())).thenReturn(Optional.of(followedUser));
        when(modelMapper.map(eq(followedUser), eq(UserWithFollowersDto.class)))
                .thenReturn(new UserWithFollowersDto(followedUser.getId(), followedUser.getUsername(), null));
        when(followRepository.findFollowsByFollowedId(followedUser.getId()))
                .thenReturn(follows.stream().filter(follow -> follow.getUserToFollow().getId() == followedUser.getId()).toList());

        UserWithFollowersDto result = userService.findAllFollowers(followedUser.getId(), "name_desc");

        // Assert
        assertEquals(followedUser.getId(), result.getUserId());
        assertEquals(2, result.getFollowers().size());
        assertEquals("Pedro Gomez", result.getFollowers().get(0).getUsername());
        assertEquals("Ana Rodriguez", result.getFollowers().get(1).getUsername());
    }

    @Test
    @DisplayName("T-0004 - FOLLOWERS UNORDERED")
    public void findAllFollowersSortsDefault() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User followedUser = follows.get(0).getUserToFollow();
        List<Follow> followerFollows = follows.stream()
                .filter(follow -> follow.getUserToFollow().getId() == followedUser.getId())
                .distinct()
                .toList();

        // Act
        when(userRepository.findById(followedUser.getId())).thenReturn(Optional.of(followedUser));
        when(modelMapper.map(eq(followedUser), eq(UserWithFollowersDto.class)))
                .thenReturn(new UserWithFollowersDto(followedUser.getId(), followedUser.getUsername(), null));
        when(followRepository.findFollowsByFollowedId(followedUser.getId()))
                .thenReturn(followerFollows);

        UserWithFollowersDto result = userService.findAllFollowers(followedUser.getId(), null);

        // Assert
        assertEquals(followedUser.getId(), result.getUserId());
        assertEquals(followedUser.getId(), result.getUserId());
        assertEquals(2, result.getFollowers().size());
        assertEquals(followerFollows.get(0).getUser().getId(), result.getFollowers().get(0).getId());
        assertEquals(followerFollows.get(1).getUser().getId(), result.getFollowers().get(1).getId());
    }

    @Test
    @DisplayName("T-0004 - NOT SELLER")
    public void findAllFollowersThrowsValidationException() {
        // Arrange
        int nonSellerId = 99;

        // Act & Assert
        when(userRepository.findById(nonSellerId))
                .thenReturn(Optional.of(new User(nonSellerId, "not-a-seller")));
        assertThrows(ValidationException.class, () -> userService.findAllFollowers(nonSellerId, null));
    }

    @Test
    @DisplayName("T-0004 - FOLLOWED ASC")
    public void findAllFollowedSortsAsc() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User follower = follows.get(0).getUser();

        // Act
        when(userRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(followRepository.findFollowsByFollowerId(follower.getId()))
                .thenReturn(follows.stream().filter(follow -> follow.getUser().getId() == follower.getId()).toList());

        UserFollowedDto result = userService.findAllFollowed(follower.getId(), "name_asc");

        // Assert
        assertEquals(follower.getId(), result.getUserId());
        assertEquals(follower.getUsername(), result.getUsername());
        assertEquals(3, result.getFollowed().size());
        assertEquals("Carlos Marquez", result.getFollowed().get(0).getUsername());
        assertEquals("Maria Lopez", result.getFollowed().get(2).getUsername());
    }

    @Test
    @DisplayName("T-0004 - FOLLOWED DESC")
    public void findAllFollowedSortsDesc() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User follower = follows.get(0).getUser();

        // Act
        when(userRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(followRepository.findFollowsByFollowerId(follower.getId()))
                .thenReturn(follows.stream().filter(follow -> follow.getUser().getId() == follower.getId()).toList());

        UserFollowedDto result = userService.findAllFollowed(follower.getId(), "name_desc");

        // Assert
        assertEquals(follower.getId(), result.getUserId());
        assertEquals(follower.getUsername(), result.getUsername());
        assertEquals(3, result.getFollowed().size());
        assertEquals("Maria Lopez", result.getFollowed().get(0).getUsername());
        assertEquals("Carlos Marquez", result.getFollowed().get(2).getUsername());
    }

    @Test
    @DisplayName("T-0004 - FOLLOWED UNORDERED")
    public void findAllFollowedSortsDefault() {
        // Arrange
        List<Follow> follows = TestUtils.createUserFollows();
        User follower = follows.get(0).getUser();
        List<Follow> userFollows = follows.stream()
                .filter(follow -> follow.getUser().getId() == follower.getId())
                .distinct()
                .toList();

        // Act
        when(userRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(followRepository.findFollowsByFollowerId(follower.getId()))
                .thenReturn(userFollows);

        UserFollowedDto result = userService.findAllFollowed(follower.getId(), null);

        // Assert
        assertEquals(follower.getId(), result.getUserId());
        assertEquals(follower.getUsername(), result.getUsername());
        assertEquals(3, result.getFollowed().size());
        assertEquals(userFollows.get(0).getUserToFollow().getId(), result.getFollowed().get(0).getId());
        assertEquals(userFollows.get(2).getUserToFollow().getId(), result.getFollowed().get(2).getId());
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWERS ALPHABETICAL ORDER WITH EXCEPTION")
    public void getFollowersAlphabeticalOrderException() {
        // Arrange
        String order = "verdura";
        user.setSeller(true);

        // Act
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowedId(user.getId())).thenReturn(follows);
        when(modelMapper.map(any(), eq(UserWithFollowersDto.class))).thenAnswer(invocation -> {
            User mappedUser = invocation.getArgument(0);
            return new UserWithFollowersDto(mappedUser.getId(), mappedUser.getUsername(), List.of());
        });
        ValidationException exception = assertThrows(ValidationException.class, () -> userService.findAllFollowers(user.getId(), order));

        // Assert
        assertEquals("Cannot order by " + order, exception.getMessage());
    }


    @Test
    @DisplayName("T-0003 - GET FOLLOWEDS ALPHABETICAL ORDER NAME-ASC")
    public void getFollowedsAlphabeticalOrderAsc() {
        // Arrange
        String order = "name_asc";

        // Act & Assert
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowerId(user.getId())).thenReturn(follows);

        assertDoesNotThrow(() -> userService.findAllFollowed(user.getId(), order));
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWEDS ALPHABETICAL ORDER NAME-DESC")
    public void getFollowedsAlphabeticalOrderDescShouldBeOk() {
        // Arrange
        String order = "name_desc";

        // Act & Assert
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowerId(user.getId())).thenReturn(follows);

        assertDoesNotThrow(() -> userService.findAllFollowed(user.getId(), order));
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWEDS ALPHABETICAL ORDER WITH EXCEPTION")
    public void getFollowedsAlphabeticalOrderException() {
        // Arrange
        String order = "verdura";

        // Act
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(followRepository.findFollowsByFollowerId(user.getId())).thenReturn(follows);
        ValidationException exception = assertThrows(ValidationException.class, () -> userService.findAllFollowed(user.getId(), order));

        // Assert
        assertEquals("Cannot order by " + order, exception.getMessage());
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWERS ALPHABETICAL ORDER WITH EXCEPTION NOT FOUND USER")
    public void getFollowersAlphabeticalOrderExceptionNotFoundUser() {
        // Arrange
        int inexistentUserId = 99;
        String order = "name_asc";

        // Act
        when(userRepository.findById(inexistentUserId)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.findAllFollowers(inexistentUserId, order));

        // Assert
        assertEquals("User " + inexistentUserId + " not found", exception.getMessage());
    }

    @Test
    @DisplayName("T-0003 - GET FOLLOWEDS ALPHABETICAL ORDER WITH EXCEPTION NOT FOUND USER")
    public void getFollowedsAlphabeticalOrderExceptionNotFoundUser() {
        // Arrange
        int inexistentUserId = 99;
        String order = "name_asc";

        // Act
        when(userRepository.findById(inexistentUserId)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.findAllFollowed(inexistentUserId, order));

        // Assert
        assertEquals("User " + inexistentUserId + " not found", exception.getMessage());
    }

    @Test
    @DisplayName("T-0007 - COUNT FOLLOWERS")
    public void countFollowersShouldBeOk() {
        //Arrange
        User userFollowed = new User(1, "UsuarioSeguido", true);
        User userFollower = new User(2, "UsuarioSeguidor", false);
        List<Follow> follows = List.of(new Follow(userFollower, userFollowed));
        FollowersCountDto expectedFollowersCountDto = new FollowersCountDto(userFollowed.getId(), userFollowed.getUsername(), follows.size());

        //Act
        when(userRepository.findById(userFollowed.getId())).thenReturn(Optional.of(userFollowed));
        when(followRepository.findFollowsByFollowedId(userFollowed.getId())).thenReturn(follows);
        FollowersCountDto resultFollowersCountDto = userService.countFollowers(userFollowed.getId());

        //Assert
        assertEquals(expectedFollowersCountDto.getFollowersCount(), resultFollowersCountDto.getFollowersCount());
        assertEquals(expectedFollowersCountDto.getUserId(), resultFollowersCountDto.getUserId());
        assertEquals(expectedFollowersCountDto.getUsername(), resultFollowersCountDto.getUsername());
    }

    @Test
    @DisplayName("T-0007 - COUNT FOLLOWERS WHEN NOT FOUND USER")
    public void countFollowersNotFoundUserException() {
        //Arrange
        int inexistentUserId = 99;

        //Act
        when(userRepository.findById(inexistentUserId)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.countFollowers(inexistentUserId));

        // Assert
        assertEquals("User " + inexistentUserId + " not found", exception.getMessage());

    }

    @Test
    @DisplayName("T-0007 - COUNT FOLLOWERS WHEN IS NOT A SELLER")
    public void countFollowersNotSellerValidation() {
        //Arrange
        user.setSeller(false);

        //Act
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        ValidationException exception = assertThrows(ValidationException.class, () -> userService.countFollowers(user.getId()));

        // Assert
        assertEquals("User " + user.getId() + " is not a seller", exception.getMessage());

    }

    @Test
    @DisplayName("T0001 - USER TO FOLLOW EXISTS")
    public void userToFollowShouldExist() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(userId, "UsuarioSeguidor", false);
        User userToFollow = new User(userIdToFollow, "UsuarioSeguido", true);

        // Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

        // Assert
        assertDoesNotThrow(() -> userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - USER TO FOLLOW IS NOT A SELLER")
    public void userToFollowIsNotSeller() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(userId, "UsuarioSeguidor", false);
        User userToFollow = new User(userIdToFollow, "UsuarioSeguido", false);

        // Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

        // Assert
        assertThrows(ValidationException.class, () -> userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - USER NOT FOUND")
    public void userNotFound() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(userId, "UsuarioSeguidor", false);

        // Act
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Assert
        assertThrows(NotFoundException.class, () -> userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - USER TO FOLLOW NOT FOUND")
    public void userToFollowNotFound() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(userId, "UsuarioSeguidor", false);

        // Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.empty());

        // Assert
        assertThrows(NotFoundException.class, () -> userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - USER CAN'T FOLLOW HIMSELF")
    public void userCantFollowHimself() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 1;
        User user = new User(userId, "UsuarioSeguidor", false);
        // Act & Assert
        assertThrows(ValidationException.class, () -> userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - USER ALREADY FOLLOWS USER TO FOLLOW")
    public void userAlreadyFollowsUserToFollow() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(userId, "UsuarioSeguidor", false);
        User userToFollow = new User(userIdToFollow, "UsuarioSeguido", true);
        Follow follow = new Follow(user, userToFollow);

        // Act
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.of(userToFollow));
        when(followRepository.findFollowsByFollowerId(userId)).thenReturn(List.of(follow));

        // Assert
        assertThrows(ValidationException.class, () -> userService.followUser(userId, userIdToFollow));

    }
}