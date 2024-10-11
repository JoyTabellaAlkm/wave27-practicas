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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
        int userId = 4;
        int userIdToFollow = 2;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.http_code").value("200"))
                .andExpect(jsonPath("$.message").value("Se empezó a seguir a Bob"));
    }

    @Test
    @DisplayName("TI-0009: Probar seguir a un vendedor que ya esta en su lista de seguidores")
    void followSellerUserAlreadyFollowed() throws Exception {
        int userId = 2;
        int userIdToFollow = 1;
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
        int userId = 2;
        int userIdToUnfollow = 1;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.http_code").value("200"))
                .andExpect(jsonPath("$.message").value("Se dejó de seguir a Alice"));
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
        String order = "name_desc";
        int userFollowers = 1;
        mockMvc.perform(get("/users/{userId}/followers/list", userFollowers)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.response.user_id").value(1))
                .andExpect(jsonPath("$.response.user_name").value("Alice"))
                .andExpect(jsonPath("$.response.followers").isArray())
                .andExpect(jsonPath("$.response.followers[0].user_name").value("Bob"));
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

        String order = "name_asc";
        mockMvc.perform(get("/users/{userId}/followed/list", 2)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.response.user_id").value(2))
                .andExpect(jsonPath("$.response.user_name").value("Bob"))
                .andExpect(jsonPath("$.response.followed").isArray())
                .andExpect(jsonPath("$.response.followed[0].user_name").value("Alice"));
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
