package ar.com.mercadolibre.socialmeli.unit.service;

import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.Product;
import ar.com.mercadolibre.socialmeli.entity.User;

import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerCountResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserOkResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowedResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerListResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserNameResponseDTO;

import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.impl.RepositoryImpl;
import ar.com.mercadolibre.socialmeli.service.impl.UserServiceImpl;


import ar.com.mercadolibre.socialmeli.util.UtilTest;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ar.com.mercadolibre.socialmeli.util.UtilTest.createUserWithFollowed;
import static ar.com.mercadolibre.socialmeli.util.UtilTest.createUsersWithPosts;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    RepositoryImpl repository;

    @InjectMocks
    UserServiceImpl userService;

    private User user1;
    private List<User> users;
    private List<User> users1;


    @BeforeEach
    void setUp() {
        users = UtilTest.createUsers();
        user1 = createUserWithFollowed();
        users1 = createUsersWithPosts();

    }

    @Test
    @DisplayName("TB-0001 - Follow a specific user by ID")
    public void followASpecificUserByIdTest() {
        Product product1 = new Product(1, "Silla gamer", "Gamer",  "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2024, 9, 28), 100, 15000.00, false, 0.0 );

        Product product2 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 27), 300, 30000.00, true, 0.3);

        Product product3 = new Product(2, "Teclado mecánico", "Periférico", "Logitech", "Negro", "RGB");
        Post post3 = new Post(1, product3, LocalDate.of(2024, 9, 29), 200, 5000.00, false, 0.0 );

        // User 1 tiene 2 post
        User user = new User();
        user.setUserId(1);
        user.setPosts(Arrays.asList(post1, post2));

        User user2 = new User();
        user2.setUserId(2);
        user2.setFollowedIds(new ArrayList<>());
        user2.setFollowedIds(Collections.singletonList(3));
        user2.setPosts(Collections.singletonList(post3));

        when(repository.existId(2)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user);
        when(repository.getUserById(2)).thenReturn(user2);
        when(repository.updateUser(user)).thenReturn(true);

        UserOkResponseDTO dto = userService.followASpecificUserById(1,2);

        verify(repository).updateUser(user);
        verify(repository).existId(2);
        verify(repository).getUserById(1);
        verify(repository).getUserById(2);
        assertEquals(dto.getResponse(),"OK");
    }

    @Test
    @DisplayName("TB-0001 - Follow someone they already follow.")
    public void userWantsToFollowSomeoneTheyAlreadyFollow() {
        Product product1 = new Product(1, "Silla gamer", "Gamer",  "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2024, 9, 28), 100, 15000.00, false, 0.0 );

        Product product2 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 27), 300, 30000.00, true, 0.3);

        Product product3 = new Product(2, "Teclado mecánico", "Periférico", "Logitech", "Negro", "RGB");
        Post post3 = new Post(1, product3, LocalDate.of(2024, 9, 29), 200, 5000.00, false, 0.0 );

        // User 1 tiene 2 post
        User user1 = new User();
        user1.setUserId(1);
        user1.setPosts(Arrays.asList(post1, post2));

        // User 2 tiene 1 post
        User user2 = new User();
        user2.setUserId(2);
        user2.setFollowedIds(new ArrayList<>());
        user2.setFollowedIds(Collections.singletonList(3));
        user2.setPosts(Collections.singletonList(post3));
        user1.addFollowedId(2);

        when(repository.existId(2)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user1);
        when(repository.getUserById(2)).thenReturn(user2);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(1,2));

        verify(repository).existId(2);
        verify(repository).getUserById(1);
        verify(repository).getUserById(2);

        assertEquals(exception.getMessage(), "User ID: 1 already follows User ID: 2");
    }


    @Test
    @DisplayName("TB-0001 - Follow a non existing user by ID.")
    public void followNotExistASpecificUserByIdTest() {
        when(repository.existId(6)).thenReturn(false);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(1,6));

        verify(repository).existId(6);
        assertEquals(exception.getMessage(),"User to follow ID: " + 6 + " doesn't exist.");
    }

    @Test
    @DisplayName("TB-0001 Usuario quiere seguir a un usuario que no es vendedor.")
    public void userFollowToNotSellerTest() {
        User user1 = new User(1, "Fernando Baldrich");

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user1);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(2,1));

        verify(repository).existId(1);
        verify(repository).getUserById(1);
        assertEquals(exception.getMessage(),"User to follow is not a seller");
    }

    @Test
    @DisplayName("T-0001 - Follow no exist")
    public void userNotExistFollowTest() {

        Product product1 = new Product(1, "Silla gamer", "Gamer",  "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2024, 9, 28), 100, 15000.00, false, 0.0 );

        Product product2 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 27), 300, 30000.00, true, 0.3);

        User user1 = new User();
        user1.setUserId(1);
        user1.setPosts(Arrays.asList(post1, post2));

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user1);
        when(repository.getUserById(6)).thenReturn(null);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(6,1));

        verify(repository).existId(1);
        verify(repository).getUserById(1);
        verify(repository).getUserById(6);
        assertEquals(exception.getMessage(),"User ID: 6 doesn't exist.");
    }

    @Test
    @DisplayName("TB-0001 - Followed list update.")
    public void sizeListFollowTest() {
        Product product1 = new Product(1, "Silla gamer", "Gamer", "Racer", "Red", "Special Edition");
        Post post1 = new Post(1, product1, LocalDate.of(2024, 9, 28), 100, 15000.00, false, 0.0);

        Product product2 = new Product(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD");
        Post post2 = new Post(2, product2, LocalDate.of(2024, 9, 27), 300, 30000.00, true, 0.3);

        User user1 = new User();
        user1.setUserId(1);
        user1.setPosts(Arrays.asList(post1, post2));

        User user2 = new User();
        user2.setUserId(2);
        user2.setFollowedIds(new ArrayList<>());

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user1);
        when(repository.getUserById(2)).thenReturn(user2);
        when(repository.updateUser(user2)).thenReturn(false);


        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.followASpecificUserById(2, 1));

        verify(repository).existId(1);
        verify(repository).getUserById(1);
        verify(repository).getUserById(2);
        verify(repository).updateUser(user2);

        assertEquals("Ocurio un error al actualizar el User ID: 2", exception.getMessage());
    }

    @Test
    @DisplayName("TB-0001 - Usert with Zero ID and send exception BadRequestException invalid Ids.")
    public void AUserCannotHaveZeroIdTest() {

        BadRequestException userNull = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(null,1));
        BadRequestException followNull = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(1,null));
        BadRequestException userIdZero = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(0,1));
        BadRequestException followIdZero = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(1,0));
        BadRequestException userCannotFollowHimself = assertThrows(BadRequestException.class, () -> userService.followASpecificUserById(1,1));

        assertEquals("Invalid IDs", userNull.getMessage());
        assertEquals("Invalid IDs", followNull.getMessage());
        assertEquals("Invalid IDs", userIdZero.getMessage());
        assertEquals("Invalid IDs", followIdZero.getMessage());
        assertEquals("Invalid IDs", userCannotFollowHimself.getMessage());
    }

    @Test
    @DisplayName("T-0004 - Order Ascendent Followed")
    public void orderByDateAscendentFollowedHappy() {
        // Arrange
        Integer id = 2;
        String order = "name_asc";
        List<UserFollowedResponseDTO> userFollowedResponseDTOS1 = List.of(new UserFollowedResponseDTO(2,"Fernando", List.of(new UserNameResponseDTO(3, "Emilia"), new UserNameResponseDTO(4, "Stephanie"))));

        // Act

        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        List<UserFollowedResponseDTO> userFollowedResponseDTOS = userService.findByFollowed(id, order);
        System.out.println("Expected: " + userFollowedResponseDTOS);
        System.out.println("Actual: " + userFollowedResponseDTOS1);
        // Assert
        assertEquals(userFollowedResponseDTOS, userFollowedResponseDTOS1);
    }

    @Test
    @DisplayName("T-0004 - Order Ascendent Follower")
    public void orderByDateAscendentFollowerHappy() {
        // Arrange
        Integer id = 2;
        String order = "name_asc";

        UserFollowerListResponseDTO userFollowerListResponseDTO1 = new UserFollowerListResponseDTO(2, "Fernando", List.of(new UserNameResponseDTO(1, "Delfina"), new UserNameResponseDTO(3, "Emilia")));

        // Act
        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        UserFollowerListResponseDTO userFollowerListResponseDTO = userService.getFollowerList(id, order);
        System.out.println("Expected: " + userFollowerListResponseDTO);
        System.out.println("Actual: " + userFollowerListResponseDTO1);

        // Assert
        assertEquals(userFollowerListResponseDTO, userFollowerListResponseDTO1);
    }


    @Test
    @DisplayName("T-0004 - User Non Existant")
    public void orderByDateAscendentUserNonExistant() {
        // Arrange
        Integer userId = 784539575;
        String order = "name_asc";

        when(repository.existId(userId)).thenReturn(false);

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> userService.findByFollowed(userId, order));

        // Assert
        assertEquals("User ID: " + userId + " doesn't exist.", notFoundException.getMessage());
    }

    @Test
    @DisplayName("T-0004 - Order Non Existant")
    public void orderByDateAscendentOrderNonExistant() {
        // Arrange
        Integer userId = 2;
        String order = "invalid_orderrr";

        when(repository.existId(userId)).thenReturn(true);
        when(repository.getUserById(userId)).thenReturn(users.get(1));

        // Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.findByFollowed(userId, order));

        // Assert
        assertEquals("Invalid order parameter: " + order, exception.getMessage());
        verify(repository, times(0)).getUsers();
    }

    @Test
    @DisplayName("T-0004 - Order Descendent Followed")
    public void orderByDateDescendentFollowedHappy(){

        // Arrange
        Integer id = 2;
        String order = "name_desc";

        List<UserFollowedResponseDTO> userFollowedResponseDTOS1 = List.of(new UserFollowedResponseDTO(2,"Fernando", List.of(new UserNameResponseDTO(4, "Stephanie"), new UserNameResponseDTO(3, "Emilia"))));

        // Act
        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        List<UserFollowedResponseDTO> userFollowedResponseDTOS = userService.findByFollowed(id, order);
        System.out.println("Expected: " + userFollowedResponseDTOS);
        System.out.println("Actual: " + userFollowedResponseDTOS1);

        // Assert

        assertEquals(userFollowedResponseDTOS, userFollowedResponseDTOS1);
    }

    @Test
    @DisplayName("T-0004 - Order Descendent Follower")
    public void orderByDateDescendentFollowerHappy(){

        // Arrange
        Integer id = 2;
        String order = "name_desc";
        UserFollowerListResponseDTO userFollowerListResponseDTO1 = new UserFollowerListResponseDTO(2, "Fernando", List.of(new UserNameResponseDTO(3, "Emilia"), new UserNameResponseDTO(1, "Delfina")));

        // Act
        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        UserFollowerListResponseDTO userFollowerListResponseDTO = userService.getFollowerList(id, order);
        System.out.println("Expected: " + userFollowerListResponseDTO);
        System.out.println("Actual: " + userFollowerListResponseDTO1);

        // Assert

        assertEquals(userFollowerListResponseDTO, userFollowerListResponseDTO1);
    }

    @Test
    @DisplayName("TB-0004 - User doesn't follow anyone")
    public void noOrderAsc() {

        // Arrange
        Integer id = 2;
        String order = "name_asc";

        User user1 = users.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found"));

        user1.setFollowedIds(Collections.emptyList());

        // Act
        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(user1);

        // Assert
        Exception exception = assertThrows(BadRequestException.class, () -> userService.findByFollowed(id, order));

        String expectedMessage = "User with the ID: 2 is not following anyone.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("TB-0004 - User doesn't have followers")
    public void noOrderDesc() {
        // Arrange
        Integer id = 1;
        String order = "name_desc";

        User user2 = users.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found"));

        // Act
        when(repository.existId(id)).thenReturn(true);
        when(repository.getUserById(id)).thenReturn(user2);

        List<User> allUsers = users.stream()
                .peek(user -> {
                    if (user.getFollowedIds() == null || !user.getFollowedIds().contains(id)) {
                        user.setFollowedIds(Collections.emptyList());
                    } else {
                        user.setFollowedIds(Collections.singletonList(id));
                    }
                })
                .collect(Collectors.toList());

        when(repository.getUsers()).thenReturn(allUsers);

        // Assert
        UserFollowerListResponseDTO userFollowerListResponseDTO = userService.getFollowerList(id, order);
        assertTrue(userFollowerListResponseDTO.getFollowers().isEmpty());
    }


    @Test
    @DisplayName("T-0002 - Exist")
    public void checkUserExistsBeforeUnfollow() {

        // Arrange
        Integer userToUnfollow= 2;
        String expectedResponse = "OK";

        // Act
        Mockito.when(repository.existId(user1.getUserId())).thenReturn(true);
        Mockito.when(repository.existId(userToUnfollow)).thenReturn(true);
        Mockito.when(repository.getUserById(user1.getUserId())).thenReturn(user1);

        UserOkResponseDTO responseDTO = userService.unfollowASpecificUserById(user1.getUserId(), userToUnfollow);

        // Assert
        Assertions.assertEquals(expectedResponse, responseDTO.getResponse());
        verify(repository, atLeastOnce()).existId(user1.getUserId());
        verify(repository, atLeastOnce()).existId(userToUnfollow);
        verify(repository, atLeastOnce()).getUserById(user1.getUserId());
    }

    @Test
    @DisplayName("T-0002 - NotExist")
    public void checkUserBeforeUnfollowNotExistS1() {

        // Arrange
        int userToUnfollow = 10;

        //Act
        Mockito.when(repository.existId(user1.getUserId())).thenReturn(true);
        Mockito.when(repository.existId(userToUnfollow)).thenReturn(false);


        BadRequestException thrown = Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.unfollowASpecificUserById(user1.getUserId(), userToUnfollow));

        //Assert
        Assertions.assertEquals("Invalid User to Unfollow ID: " + userToUnfollow, thrown.getMessage());
        verify(repository, atLeastOnce()).existId(user1.getUserId());
        verify(repository, atLeastOnce()).existId(userToUnfollow);
    }

    @Test
    @DisplayName("T-0002 - Not Exist for beeing negative")
    public void checkUserBeforeUnfollowNotExistS2() {

        // Arrange
        int userToUnfollow = -1;

        //Act
        Mockito.when(repository.existId(user1.getUserId())).thenReturn(true);


        BadRequestException thrown = Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.unfollowASpecificUserById(user1.getUserId(), userToUnfollow));

        //Assert
        Assertions.assertEquals("Invalid User to Unfollow ID: -1", thrown.getMessage());
        verify(repository, atLeastOnce()).existId(user1.getUserId());
    }

    @Test
    @DisplayName("TB-0002 - User does not follow seller")
    public void checkUserDoesNotFollowSeller() {

        // Arrange
        Integer userIdToUnfollow = 3;

        // Act
        User userMock = Mockito.mock(User.class);
        Mockito.when(repository.existId(user1.getUserId())).thenReturn(true);
        Mockito.when(repository.existId(userIdToUnfollow)).thenReturn(true);
        Mockito.when(repository.getUserById(user1.getUserId())).thenReturn(userMock);

        Mockito.when(userMock.getFollowedIds()).thenReturn(Collections.emptyList());

        BadRequestException thrown = Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.unfollowASpecificUserById(user1.getUserId(), userIdToUnfollow)
        );

        // Assert
        Assertions.assertEquals("User ID: " + user1.getUserId() + " does not follow User ID: " + userIdToUnfollow, thrown.getMessage());

        // Verificaciones
        verify(repository, atLeastOnce()).existId(user1.getUserId());
        verify(repository, atLeastOnce()).existId(userIdToUnfollow);
        verify(repository, atLeastOnce()).getUserById(user1.getUserId());
    }

    @Test
    @DisplayName("T-0003 - Happy Path No Ordering")
    public void getFollowerListHappyTest(){
        //arrange
        //User 3 follows 2
        User user = users1.stream().filter(u -> u.getUserId().equals(3)).findFirst().orElseThrow(() -> new RuntimeException("Test user not found"));
        when(repository.existId(user.getUserId())).thenReturn(true);
        when(repository.getUserById(user.getUserId())).thenReturn(user);
        when(repository.getUsers()).thenReturn(users1);

        //act
        UserFollowerListResponseDTO response = userService.getFollowerList(user.getUserId(), null);

        //assert
        verify(repository, atLeastOnce()).existId(user.getUserId());
        verify(repository, atLeastOnce()).getUserById(user.getUserId());
        verify(repository, atLeastOnce()).getUsers();
        assertEquals(response.getUserId(), user.getUserId());
        assertFalse(response.getFollowers().isEmpty());
        assertEquals(1, response.getFollowers().size());
        assertEquals(2, response.getFollowers().stream().findFirst().get().getUserId());
    }

    @Test
    @DisplayName("T-0003 - User ID is null")
    public void getFollowerListSadPath1Test(){
        //act
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> userService.getFollowerList(null, null));

        //assert
        assertEquals(thrown.getMessage(), "User ID: " + null + " is invalid.");
    }

    @Test
    @DisplayName("T-0003 - User ID is negative")
    public void getFollowerListSadPath2Test(){
        //arrange
        Integer userId = -1;

        //act
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> userService.getFollowerList(userId, null));

        //assert
        assertEquals(thrown.getMessage(), "User ID: " + userId + " is invalid.");
    }

    @Test
    @DisplayName("T-0003 - User ID doesn't exist")
    public void getFollowerListSadPath3Test(){
        //arrange
        Integer userId = 50;
        when(repository.existId(userId)).thenReturn(false);

        //act
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> userService.getFollowerList(userId, null));

        //assert
        verify(repository, atLeastOnce()).existId(userId);
        assertEquals(thrown.getMessage(), "User ID: " + userId + " doesn't exist.");
    }

    @Test
    @DisplayName("T-0007 - Success counting More than Zero")
    public void getFollowersCountingFollowersWhenMoreThanZero(){
        //Arrange
        Integer userId = 1;
        List<User> users = UtilTest.createUsersWithPosts();
        when(repository.existId(userId)).thenReturn(true);
        when(repository.getUsers()).thenReturn(users);
        when(repository.getUserById(userId)).thenReturn(users.getFirst());

        //Act
        UserFollowerCountResponseDTO response = userService.getFollowerCount(userId);

        //Assert
        assertNotNull(response);
        assertEquals(1, response.getFollowersCount());
        verify(repository, times(1)).existId(userId);
        verify(repository, times(1)).getUsers();
        verify(repository, times(1)).getUserById(userId);
    }

    @Test
    @DisplayName("T-0007 - Success counting Zero")
    public void getFollowersCountingFollowersWhenZero(){
        //Arrange
        Integer userId = 2;
        List<User> users = UtilTest.createUsersWithPosts();
        when(repository.existId(userId)).thenReturn(true);
        when(repository.getUsers()).thenReturn(users);
        when(repository.getUserById(userId)).thenReturn(users.getFirst());

        //Act
        UserFollowerCountResponseDTO response = userService.getFollowerCount(userId);

        //Assert
        assertNotNull(response);
        assertEquals(0, response.getFollowersCount());
        verify(repository, times(1)).existId(userId);
        verify(repository, times(1)).getUsers();
        verify(repository, times(1)).getUserById(userId);
    }

    @Test
    @DisplayName("T-0007 - Failed Null ID")
    public void getFollowersCountWhenNull(){
        //Act
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> userService.getFollowerCount(null));

        //Assert
        assertNotNull(thrown);
        assertEquals("User ID: " + null + " is invalid.", thrown.getMessage());
        verify(repository, times(0)).existId(anyInt());
        verify(repository, times(0)).getUsers();
        verify(repository, times(0)).getUserById(anyInt());
    }

    @Test
    @DisplayName("T-0007 - Failed Non Existing ID")
    public void getFollowersCountWhenIDNonExisting(){
        //Arrange
        Integer userId = 999;
        when(repository.existId(userId)).thenReturn(false);

        //Act
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> userService.getFollowerCount(userId));

        //Assert
        assertNotNull(thrown);
        assertEquals("User ID: " + userId + " doesn't exist.", thrown.getMessage());
        verify(repository, times(1)).existId(userId);
        verify(repository, times(0)).getUsers();
        verify(repository, times(0)).getUserById(anyInt());
    }
}

