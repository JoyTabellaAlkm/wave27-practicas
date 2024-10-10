package com.sprint1.be_java_hisp_w27_g04.integracion.controller;

import com.sprint1.be_java_hisp_w27_g04.dto.response.*;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import com.sprint1.be_java_hisp_w27_g04.service.IUsersService;
import com.sprint1.be_java_hisp_w27_g04.utils.TestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IUsersService usersService;

    @Autowired
    IProductsService productsService;

    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName(value = "TI-0008: Probar obtencion de seguidores de un usuario exitosamente")
    public void testGetUserFollowersCountByIdOk() throws Exception {
        int userId = 5;
        UserFollowersCountResponseDTO userFollowersCountResponseDTO = new UserFollowersCountResponseDTO(userId, "Bob", 0);
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id")
                        .value(userId))
                .andExpect(jsonPath("$.user_name")
                        .value("Eve"))
                .andExpect(jsonPath("$.followers_count")
                        .value(0));
    }

    @Test
    @DisplayName(value = "TI-0008: Probar obtencion de seguidores de un usuario error por usuario inexistente")
    public void testGetUserFollowersCountByIdUserNotFound() throws Exception {
        int userId = 1000;
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("El usuario no existe"));
    }

    @Test
    @DisplayName("TI-0009: Probar seguir a un usuario exitosamente")
    void followSellerSuccess() throws Exception {
        PostRequestDTO post = TestUtils.getPostRequest();
        post.setUserId(2);
        productsService.newPost(TestUtils.getPostRequest());
        int userId = 3;
        int userIdToFollow = 2;
        ResponseDTO responseDTO = new ResponseDTO("200", "Se empezó a seguir a Bob");
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.http_code").value("200"))
                .andExpect(jsonPath("$.message").value("Se empezó a seguir a Bob"));
    }

    @Test
    @DisplayName("TI-0009: Probar seguir a un vendedor que ya esta en su lista de seguidores")
    void followSellerUserAlreadyFollowed() throws Exception {
        PostRequestDTO post = TestUtils.getPostRequest();
        post.setUserId(2);
        productsService.newPost(TestUtils.getPostRequest());
        usersService.followSeller(1, 2);
        int userId = 1;
        int userIdToFollow = 2;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ya está en sus vendedores seguidos"));
    }

    @Test
    @DisplayName("TI-0009: Probar seguir a un usuario que no es vendedor")
    void followSellerUserIsNotSeller() throws Exception {
        int userId = 1;
        int userIdToFollow = 3;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir porque no es vendedor"));
    }

    @Test
    @DisplayName("TI-0010: Probar dejar de seguir a un usuario exitosamente")
    void unfollowSellerSuccess() throws Exception {
        PostRequestDTO post = TestUtils.getPostRequest();
        post.setUserId(2);
        productsService.newPost(TestUtils.getPostRequest());
        usersService.followSeller(1, 2);
        int userId = 1;
        int userIdToUnfollow = 2;
        ResponseDTO responseDTO = new ResponseDTO("200", "Se dejó de seguir a Bob");
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.http_code").value("200"))
                .andExpect(jsonPath("$.message").value("Se dejó de seguir a Bob"));
    }

    @Test
    @DisplayName("TI-0010: Probar dejar de seguir a un vendedor no seguido")
    void unfollowSellerUserNotFollowed() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 3;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("No sigue a ese usuario"));
    }


    @Test
    @DisplayName("TI-0011: Obtener seguidores exitosamente")
    public void testGetFollowersSuccess() throws Exception {
        var user = TestUtils.getUserWithFollowersTest();
        userRepository.save(user);

        String order = "name_desc";
        mockMvc.perform(get("/users/{userId}/followers/list", user.getId())
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.response.user_id").value(user.getId()))
                .andExpect(jsonPath("$.response.user_name").value(user.getName()))
                .andExpect(jsonPath("$.response.followers").isArray())
                .andExpect(jsonPath("$.response.followers[0].user_name").value("Charlie"))
                .andExpect(jsonPath("$.response.followers[1].user_name").value("Bob"));
    }


    @Test
    @DisplayName("TI-0011: Obtener seguidores de un user que no existe")
    public void testGetFollowersUserNotFound() throws Exception {
        int userId = 999;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Usuario no encontrado"));
    }

    @Test
    @DisplayName("TI-0012: Obtener seguidos por un usuario exitosamente")
    public void testGetFollowedSuccess() throws Exception {

        var user = TestUtils.getUserWithFollowedTest();
        userRepository.save(user);

        String order = "name_asc";
        mockMvc.perform(get("/users/{userId}/followed/list", user.getId())
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.response.user_id").value(user.getId()))
                .andExpect(jsonPath("$.response.user_name").value(user.getName()))
                .andExpect(jsonPath("$.response.followed").isArray())
                .andExpect(jsonPath("$.response.followed[0].user_name").value("Bob"))
                .andExpect(jsonPath("$.response.followed[1].user_name").value("Charlie"));
    }

    @Test
    @DisplayName("TI-0012: Obtener  seguidos por un usuario que no existe")
    public void testGetFollowedUserNotFound() throws Exception {
        int userId = 999;

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User not found"));
    }



}
