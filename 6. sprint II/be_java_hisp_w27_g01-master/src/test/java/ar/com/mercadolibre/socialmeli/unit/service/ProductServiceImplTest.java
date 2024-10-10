package ar.com.mercadolibre.socialmeli.unit.service;


import ar.com.mercadolibre.socialmeli.dto.request.ActivatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.CreatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.ProductRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.Product;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.exception.BadRequestException;
import ar.com.mercadolibre.socialmeli.exception.NotFoundException;
import ar.com.mercadolibre.socialmeli.repository.impl.RepositoryImpl;
import ar.com.mercadolibre.socialmeli.service.impl.ProductServiceImpl;
import ar.com.mercadolibre.socialmeli.util.UtilTest;
import ar.com.mercadolibre.socialmeli.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    RepositoryImpl repository;

    @InjectMocks
    ProductServiceImpl productService;


    private List<User> users;

    @BeforeEach
    void setUp() {
        users = UtilTest.createUsersWithPosts();
    }

    @DisplayName("T-0005 - Success")
    @Test
    void testGetRecentPostFromFollowedUsers_Success() {

        //Arrange
        PostDetailsResponseDTO postDetails = new PostDetailsResponseDTO(1,2, LocalDate.of(2024, 9, 27),
                new ProductResponseDTO(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD"),300,
                30000.0
        );

        LocalDate dateExpected = LocalDate.of(2024, 9, 27);

        when(repository.existId(3)).thenReturn(true);
        when(repository.getUserById(3)).thenReturn(users.get(2));
        when(repository.getUsers()).thenReturn(users);

        //Act
        FollowersListResponseDTO response = productService.getRecentPostFromFollowedUsers(3, "date_asc");


        //Assert
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().contains(postDetails));
        assertEquals(dateExpected, response.getPosts().getFirst().getDate());
        verify(repository, times(1)).existId(3);
        verify(repository, times(1)).getUserById(3);
        verify(repository, times(1)).getUsers();
    }

    @DisplayName("T-0005 - User not found")
    @Test
    void testGetRecentPostFromFollowedUsers_UserNotFound() {
        //Arrange
        Integer id = 999;
        when(repository.existId(id)).thenReturn(false);

        //Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.getRecentPostFromFollowedUsers(999, null));

        //Assert
        assertEquals("User ID: " + id + " doesn´t exist.", exception.getMessage());
        verify(repository, times(1)).existId(999);
        verify(repository, never()).getUserById(anyInt());
        verify(repository, never()).getUsers();
    }

    @DisplayName("T-0005 - No followed users")
    @Test
    void testGetRecentPostFromFollowedUsers_NoFollowedUsers() {
        //Arrange
        users.getFirst().setFollowedIds(Collections.emptyList());

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(users.getFirst());

        //Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.getRecentPostFromFollowedUsers(1, "date_asc"));

        //Assert
        assertEquals("User ID: 1 is not following anyone.", exception.getMessage());
        verify(repository, times(1)).existId(1);
        verify(repository, times(1)).getUserById(1);
        verify(repository, never()).getUsers();
    }

    @DisplayName("T-0005 - Invalid Order")
    @Test
    void testGetRecentPostFromFollowedUsers_InvalidOrderParameter() {
        //Arrange
        when(repository.existId(3)).thenReturn(true);
        when(repository.getUserById(3)).thenReturn(users.get(2));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.getRecentPostFromFollowedUsers(3, "invalid_order"));

        assertEquals("Invalid order parameter: invalid_order", exception.getMessage());
        verify(repository, times(1)).existId(3);
        verify(repository, times(1)).getUserById(3);
        verify(repository, never()).getUsers();
    }

    @DisplayName("T-0005 - No recent post")
    @Test
    void testGetRecentPostFromFollowedUsers_NoRecentPost(){
        //Arrange
        when(repository.existId(2)).thenReturn(true);
        when(repository.getUserById(2)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        //Act
        BadRequestException exception = assertThrows(BadRequestException.class, ()-> productService.getRecentPostFromFollowedUsers(2, null));

        //Assert
        assertEquals("There aren't posts of minus two weeks.", exception.getMessage());
        verify(repository, times(1)).existId(2);
        verify(repository, times(1)).getUserById(2);
        verify(repository, times(1)).getUsers();

    }


    @DisplayName("T-0005 - Success Order date_asc")
    @Test
    void testGetRecentPostFromFollowedUsers_SuccessOrderingDateAsc() {

        //Arrange
        PostDetailsResponseDTO postDetails = new PostDetailsResponseDTO(1,2, LocalDate.of(2024, 9, 27),
                new ProductResponseDTO(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD"),300,
                30000.0
        );

        LocalDate expectedFirst = LocalDate.of(2024, 9, 27);
        LocalDate expectedSecond = LocalDate.of(2024, 9, 28);

        when(repository.existId(3)).thenReturn(true);
        when(repository.getUserById(3)).thenReturn(users.get(2));
        when(repository.getUsers()).thenReturn(users);

        //Act
        FollowersListResponseDTO response = productService.getRecentPostFromFollowedUsers(3, "date_asc");


        //Assert
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().contains(postDetails));
        assertEquals(expectedFirst, response.getPosts().getFirst().getDate());
        assertEquals(expectedSecond, response.getPosts().get(1).getDate());
        verify(repository, times(1)).existId(3);
        verify(repository, times(1)).getUserById(3);
        verify(repository, times(1)).getUsers();
    }

    @DisplayName("T-0006 - Success Order date_desc")
    @Test
    void testGetRecentPostFromFollowedUsers_SuccessOrderingDateDesc() {

        //Arrange
        PostDetailsResponseDTO postDetails = new PostDetailsResponseDTO(1,2, LocalDate.of(2024, 9, 27),
                new ProductResponseDTO(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD"),300,
                30000.0
        );

        LocalDate expectedFirst = LocalDate.of(2024, 9, 28);
        LocalDate expectedSecond = LocalDate.of(2024, 9, 27);

        when(repository.existId(3)).thenReturn(true);
        when(repository.getUserById(3)).thenReturn(users.get(2));
        when(repository.getUsers()).thenReturn(users);

        //Act
        FollowersListResponseDTO response = productService.getRecentPostFromFollowedUsers(3, "date_desc");


        //Assert
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().contains(postDetails));
        assertEquals(expectedFirst, response.getPosts().getFirst().getDate());
        assertEquals(expectedSecond, response.getPosts().get(1).getDate());
        verify(repository, times(1)).existId(3);
        verify(repository, times(1)).getUserById(3);
        verify(repository, times(1)).getUsers();
    }

    @DisplayName("T-0008 - Success")
    @Test
    void testGetRecentPostSuccess(){
        //Arrange
        PostDetailsResponseDTO postDetails = new PostDetailsResponseDTO(1,2, LocalDate.of(2024, 9, 27),
                new ProductResponseDTO(3, "Monitor 4K", "Monitor", "Samsung", "Negro", "Ultra HD"),300,
                30000.0
        );
        PostDetailsResponseDTO postDetails2 = new PostDetailsResponseDTO(1, 1, LocalDate.of(2024, 9, 28)
                , new ProductResponseDTO(1, "Silla gamer", "Gamer", "Racer", "Red", "Special Edition"), 100,
                15000.0);

        LocalDate dateExpected = LocalDate.of(2024, 9, 27);

        when(repository.existId(3)).thenReturn(true);
        when(repository.getUserById(3)).thenReturn(users.get(2));
        when(repository.getUsers()).thenReturn(users);

        //Act
        FollowersListResponseDTO response = productService.getRecentPostFromFollowedUsers(3, null);

        //Assert
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().contains(postDetails));
        assertTrue(response.getPosts().contains(postDetails2));
        assertEquals(dateExpected, response.getPosts().getFirst().getDate());
        verify(repository, times(1)).existId(3);
        verify(repository, times(1)).getUserById(3);
        verify(repository, times(1)).getUsers();
    }

    @DisplayName("T-0008 - Fails only old Post")
    @Test
    void testGetRecentPostNotBringOldDates(){
        //Arrange
        when(repository.existId(2)).thenReturn(true);
        when(repository.getUserById(2)).thenReturn(users.get(1));
        when(repository.getUsers()).thenReturn(users);

        //Act
        BadRequestException exception = assertThrows(BadRequestException.class, ()-> productService.getRecentPostFromFollowedUsers(2, null));

        //Assert
        assertNotNull(exception);
        assertEquals("There aren't posts of minus two weeks.", exception.getMessage());
        verify(repository, times(1)).existId(2);
        verify(repository, times(1)).getUserById(2);
        verify(repository, times(1)).getUsers();
    }

    @DisplayName("TB - 0010 Success")
    @Test
    public void createPromoPostTest() {
        //Arrange
        var user = users.stream().filter(u -> u.getUserId().equals(1)).findFirst().orElseThrow(() -> new RuntimeException("test user not found"));

        var product = new Product();
        product.setProductId(1);
        product.setProductName("Silla Gamer");
        product.setType("Gamer");
        product.setBrand("Racer");
        product.setColor("Red");
        product.setNotes("Special Edition");

        var post = new Post();
        post.setProduct(product);
        post.setDate(LocalDate.now());
        post.setPrice(1500.5);
        post.setHasPromo(true);
        post.setDiscount(0.4);
        post.setCategory(100);

        //Arrange
        var productdto = new ProductRequestDTO();
        productdto.setProductId(1);
        productdto.setProductName("Silla Gamer");
        productdto.setType("Gamer");
        productdto.setBrand("Racer");
        productdto.setColor("Red");
        productdto.setNotes("Special Edition");

        var dto = new CreatePromoRequestDTO();
        dto.setProduct(productdto);
        dto.setDate(LocalDate.now());
        dto.setUserId(user.getUserId());
        dto.setPrice(1500.5);
        dto.setHasPromo(true);
        dto.setCategory(100);
        dto.setDiscount(0.4);

        when(repository.existId(user.getUserId())).thenReturn(true);
        when(repository.getUserById(user.getUserId())).thenReturn(user);
        when(repository.createPost(user, post)).thenReturn(1);

        //act
        CreatePromoResponseDTO promoPost = productService.createPromoPost(dto);

        //assert
        verify(repository, times(1)).existId(user.getUserId());
        verify(repository, times(1)).getUserById(user.getUserId());
        verify(repository, times(1)).createPost(user, post);
        assertEquals(1, promoPost.getCreatedId());
    }


    @Test
    @DisplayName("TB - 0005 Validate request null send exception BadRequestException")
    public void createPostTest() {
        // Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.createPost(null));

        assertEquals("PublicationDTO is null", exception.getMessage());
    }

    @DisplayName("TB - 0013 - Success Only query")
    @Test
    public void searchPostByBrandAndNameOnlyQueryTest(){
        //Arrange
        when(repository.getUsers()).thenReturn(users);

        //Act
        List<SearchResponseDTO> response = productService.searchPostByBrandAndName("silla", null);

        //Assert
        verify(repository, times(1)).getUsers();
        assertEquals(2, response.size());
        assertEquals("Silla gamer", response.getFirst().getProduct().getProductName());
    }

    @DisplayName("TB - 0013 - Query and User ID")
    @Test
    public void searchPostByBrandAndNameQueryAndUserIDTest(){
        //Arrange
        Integer userId = 1;
        when(repository.existId(userId)).thenReturn(true);
        when(repository.getUsers()).thenReturn(users);

        //Act
        List<SearchResponseDTO> response = productService.searchPostByBrandAndName("silla", userId);

        //Assert
        verify(repository, times(1)).existId(userId);
        verify(repository, times(1)).getUsers();
        assertEquals(1, response.size());
        assertEquals("Silla gamer", response.getFirst().getProduct().getProductName());
    }

    @DisplayName("TB - 0013 - User ID doesn't exist")
    @Test
    public void searchPostByBrandAndNameUserIDNonExistantTest(){
        //Arrange
        Integer userId = 5436546;
        when(repository.existId(userId)).thenReturn(false);

        //Act
        NotFoundException exception = assertThrows(NotFoundException.class, () -> productService.searchPostByBrandAndName("silla", userId));

        //Assert
        assertEquals("User ID: " + userId + " doesn´t exist.", exception.getMessage());
        verify(repository, times(1)).existId(userId);
        verify(repository, never()).getUserById(anyInt());
        verify(repository, never()).getUsers();
    }

    @DisplayName("TB - 0015 - Activate Promo Success")
    @Test
    void testActivatePromoSuccess() {
        // Arrange
        ActivatePromoRequestDTO requestDTO = new ActivatePromoRequestDTO(1, 1, 0.2);
        User user = new User();
        user.setUserId(1);
        Post post = new Post();
        post.setPostId(1);
        post.setHasPromo(false);
        post.setDiscount(0.0);
        user.setPosts(Collections.singletonList(post));

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user);

        // Act
        PostOkResponseDTO response = productService.activatePromo(requestDTO);

        // Assert
        assertNotNull(response);
        assertEquals("OK", response.getResponse());
        assertTrue(post.getHasPromo());
        assertEquals(0.2, post.getDiscount());
        verify(repository, times(1)).existId(1);
        verify(repository, times(1)).getUserById(1);
        verify(repository, times(1)).updatePost(user, post);
    }

    @DisplayName("TB - 0015 - Activate Promo User Not Found")
    @Test
    void testActivatePromoUserNotFound() {
        // Arrange
        ActivatePromoRequestDTO requestDTO = new ActivatePromoRequestDTO(999, 1, 0.2);

        when(repository.existId(999)).thenReturn(false);

        // Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.activatePromo(requestDTO));

        //Assert
        assertEquals("User ID: 999 doesn´t exist.", exception.getMessage());
        verify(repository, times(1)).existId(999);
        verify(repository, never()).getUserById(anyInt());
    }

    @DisplayName("TB - 0015 - Activate Promo Post Not Found")
    @Test
    void testActivatePromoPostNotFound() {
        // Arrange
        ActivatePromoRequestDTO requestDTO = new ActivatePromoRequestDTO(1, 999, 0.2);
        User user = new User();
        user.setUserId(1);
        user.setPosts(Collections.emptyList());

        when(repository.existId(1)).thenReturn(true);
        when(repository.getUserById(1)).thenReturn(user);

        // Act
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.activatePromo(requestDTO));

        //Assert
        assertEquals("Post ID: 999 doesn´t exist.", exception.getMessage());
        verify(repository, times(1)).existId(1);
        verify(repository, times(1)).getUserById(1);
    }

    @Test
    @DisplayName("TB-0014 - valid exception BadRequestException")
    void searchPostsByDateResponseExceptionTest() {
        //Act
        BadRequestException startDateNull = assertThrows(BadRequestException.class, ()-> productService.searchPostsByDate(null, null));

        //Assert
        assertEquals("Start date cannot be null", startDateNull.getMessage());
    }

    @Test
    @DisplayName("TB-0014 - valid endDate Null")
    void searchPostsByEndDateNullTest() {
        //Arrange
        LocalDate startDate = LocalDate.of(2024, 9, 27);

        List<User> users = new ArrayList<>();
        when(repository.getUsers()).thenReturn(users);

        List<PostDetailsResponseDTO> posts = users.stream()
                .flatMap(user -> user.getPosts().stream()
                        .filter(post -> !post.getDate().isBefore(startDate) && !post.getDate().isAfter(LocalDate.now()))
                        .map(post -> new PostDetailsResponseDTO(user.getUserId(), post.getPostId(), post.getDate(), Utils.changeEntityToDTO(post.getProduct(), ProductResponseDTO.class), post.getCategory(), post.getPrice())))
                .toList();


        //Act
        List<PostDetailsResponseDTO> response = productService.searchPostsByDate(startDate,null);

        //Assert
        assertEquals(response.size(), posts.size());
    }

    @Test
    @DisplayName("TB-0014 - Success")
    void searchPostsByDateTest() {
        //Arrange
        LocalDate startDate = LocalDate.of(2024, 9, 25);
        LocalDate p1Date = LocalDate.of(2024, 9, 28);

        PostDetailsResponseDTO postDetails = new PostDetailsResponseDTO(1,1, p1Date,
                new ProductResponseDTO(1, "Silla gamer", "Gamer", "Racer", "Red", "Special Edition"),100,
                15000.0
        );

        List<User> users = UtilTest.createUsers();

        when(repository.getUsers()).thenReturn(users);

        //Act
        List<PostDetailsResponseDTO> response = productService.searchPostsByDate(startDate,null);

        //Assert
        assertNotNull(response);
        assertEquals(response.getFirst(), postDetails);
        verify(repository, times(1)).getUsers();
    }

    @Test
    @DisplayName("TB-0011 - Promotional products have an ID that does not exist")
    void getPromoProductsCountBySellerNotExistsTest() {
        //Arrange
        Integer userId = 999;
        when(repository.existId(userId)).thenReturn(false);

        //Act
        NotFoundException response = assertThrows(NotFoundException.class, () -> productService.getPromoProductsCountBySeller(userId));

        //Assert
        verify(repository, times(1)).existId(userId);
        assertEquals(response.getMessage(),"User ID: " + userId + " doesn´t exist.");
    }

    @Test
    @DisplayName("TB-0011 - Promotional products exist")
    void getPromoProductsCountBySellerTest() {
        //Arrange
        Integer userId = 1;
        when(repository.existId(userId)).thenReturn(true);
        when(repository.getUserById(userId)).thenReturn(new User());

        //Act
        ProductPromoCountResponseDTO response = productService.getPromoProductsCountBySeller(userId);

        //Assert
        verify(repository, times(1)).existId(userId);
        verify(repository, times(1)).getUserById(userId);
        assertEquals(response.getPromoCount(),0);
    }
}
