package com.sprint1.be_java_hisp_w27_g04.utils;

import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.FollowerDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.UserFollowersCountResponseDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.Product;
import com.sprint1.be_java_hisp_w27_g04.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestUtils {

    public static User getUserWithFollowersTest() {
        User user = new User();
        user.setId(26);
        user.setName("Principal User");

        User follower1 = new User();
        follower1.setId(2);
        follower1.setName("Alice");

        User follower2 = new User();
        follower2.setId(3);
        follower2.setName("Bob");

        user.setFollowed(Set.of(follower1.getId(), follower2.getId()));
        user.setFollowers(Set.of(follower1.getId(), follower2.getId()));

        return user;
    }

    public static List<User> getFollowersListTest() {
        User follower1 = new User();
        follower1.setId(2);
        follower1.setName("Alice");

        User follower2 = new User();
        follower2.setId(3);
        follower2.setName("Bob");

        return List.of(follower1, follower2);
    }

    public static User getUserWithFollowedTest() {
        User user = new User();
        user.setId(25);
        user.setName("Principal User");

        User followed1 = new User();
        followed1.setId(2);
        followed1.setName("Alice");

        User followed2 = new User();
        followed2.setId(3);
        followed2.setName("Bob");

        user.setFollowed(Set.of(followed1.getId(), followed2.getId()));
        user.setFollowers(new HashSet<>());

        return user;
    }

    public static List<User> getFollowedListTest() {
        User followed1 = new User();
        followed1.setId(2);
        followed1.setName("Alice");

        User followed2 = new User();
        followed2.setId(3);
        followed2.setName("Bob");

        return List.of(followed1, followed2);
    }


    public static List<FollowerDTO> getFollowerDTOList() {
        return List.of(
                new FollowerDTO(2, "Alice"),
                new FollowerDTO(3, "Bob")
        );
    }

    public static List<FollowedDTO> getFollowedDTOList() {
        return List.of(
                new FollowedDTO(4, "Charlie")
        );
    }


    public static List<User> getUsersTest(){
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setFollowed(new HashSet<>());
        user.setFollowers(new HashSet<>());

        User userTest = new User();
        userTest.setId(2);
        userTest.setName("User 2");
        userTest.setPosts(Set.of(new Post()));
        userTest.setFollowers(new HashSet<>());
        userTest.setFollowed(new HashSet<>());

        return List.of(user,userTest);
    }

    public static UserFollowersCountResponseDTO getUserFollowersCountByIdBob(){
        return new UserFollowersCountResponseDTO(2, "Bob", 54);
    }

    public static PostListDTO getPostListOfLastTwoWeeksOfUserId1(){
        PostListDTO postList = new PostListDTO();
        List<PostRequestDTO> list = new ArrayList<>();
        ProductDTO chair = new ProductDTO(1, "Silla Gamer", "Tecnologia", "Gamer X", "Negra", "Silla ergonomica");
        list.add(new PostRequestDTO(2, LocalDate.now().minusWeeks(1), chair, 3, 500));
        list.add(new PostRequestDTO(2, LocalDate.now().minusWeeks(1), chair, 3, 500));
        list.add(new PostRequestDTO(2, LocalDate.now().minusWeeks(1), chair, 3, 500));
        postList.setUserId(1);
        postList.setPosts(list);
        return postList;
    }
    public static ProductDTO getProductDTO(Product product) {
        return new ProductDTO(product.getProductId(), product.getProductName(), product.getType(), product.getBrand(),
                product.getColor(), product.getNotes());

    }

    public static Post getPost(Product product, int week) {
        return new Post(1, 2, product, 3, 500.0,
                LocalDate.now().minusWeeks(week), true, 0);
    }

    public static Product getProduct() {
        return new Product(1, "Silla Gamer", "Tecnologia", "Gamer X", "Negra", "Silla ergonomica");
    }

    public static Post getPostPromotion(Product product) {
        return new Post(0, 2, product, 3, 500.0,
                LocalDate.now(), true, 0.05);
    }

    public static User getUser(int userId, int followeId) {
        User user = new User();
        user.setId(userId);
        user.setFollowed(Set.of(followeId));
        return user;
    }


    public static PostRequestDTO getPostRequest(){
        ProductDTO productDTO = new ProductDTO(7, "Silla Gamer", "Gamer", "Racer", "Red and Black", "Special Edition");
        return new PostRequestDTO(2, LocalDate.now(), productDTO, 100, 1500.50);
    }

    public static PostPromotionDTO getPostPromotion(){
        ProductDTO productDTO = new ProductDTO(7, "Silla Gamer", "Gamer", "Racer", "Red and Black", "Special Edition");
        return new PostPromotionDTO(2, LocalDate.now(), productDTO, 100, 1500.50, true, 0.05);
    }

    public static User getUserId1WithFollowers() {
      return new User(1, "Alice", Set.of(2, 3, 4), Set.of(), Set.of());
    }

    public static PostListDTO getPostListOfLastTwoWeeksOfUserId2(){
        PostListDTO postList = new PostListDTO();
        List<PostRequestDTO> list = new ArrayList<>();
        ProductDTO chair = new ProductDTO(2, "Silla Gamer", "Tecnologia", "Gamer X", "Negra", "Silla ergonomica");
        list.add(new PostRequestDTO(2, LocalDate.now().minusDays(1), chair, 3, 500));
        list.add(new PostRequestDTO(2, LocalDate.now().minusDays(2), chair, 3, 500));
        postList.setUserId(2);
        postList.setPosts(list);
        return postList;
    }

    public static PostListDTO getPostListDTOOfLastTwoWeeksOfUserId2(){
        ProductDTO productDTO1 = new ProductDTO(2, "Silla Gamer", "Gamer", "Razer",
                "Rojo", "");

        PostRequestDTO postRequestDTO1 = new PostRequestDTO(2, LocalDate.now(),
                productDTO1, 10, 10000);

        ProductDTO productDTO2 = new ProductDTO(2, "Silla Gamer", "Gamer", "Razer",
                "Rojo", "");

        PostRequestDTO postRequestDTO2 = new PostRequestDTO(2, LocalDate.now(),
                productDTO2, 10, 10000);

        PostListDTO postListDTO = new PostListDTO(2, List.of(postRequestDTO1, postRequestDTO2));

        return postListDTO;
    }

    public static User getUserWithPosts(){

        Product product1 = new Product(1, "Silla Gamer", "Gamer", "Razer",
                "Rojo", "");

        Product product2 = new Product(2, "Silla Gamer", "Gamer", "Razer",
                "Rojo", "");

        Post post1 = new Post(1,2, product1, 10, 10000,
                LocalDate.now().minusDays(2), false, 0);

        Post post2 = new Post(2,2, product1, 10, 10000,
                LocalDate.now().minusDays(5), false, 0);

        Set<Post> posts = Set.of(post1,post2);

        User user = new User(2,"Carlos", Set.of(1), Set.of(1), posts);

        return user;
    }
    public static PostListDTO getPostListOfLastTwoWeeksOfUserId12(){
        PostListDTO postList = new PostListDTO();
        List<PostRequestDTO> list = new ArrayList<>();
        ProductDTO chair = new ProductDTO(1, "Silla Gamer", "Tecnologia", "Gamer X", "Negra", "Silla ergonomica");
        list.add(new PostRequestDTO(2, LocalDate.now().minusWeeks(1), chair, 3, 500));
        postList.setUserId(1);
        postList.setPosts(list);
        return postList;
    }

}
