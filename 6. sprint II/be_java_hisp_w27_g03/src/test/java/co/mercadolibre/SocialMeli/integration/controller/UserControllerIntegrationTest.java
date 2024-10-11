package co.mercadolibre.SocialMeli.integration.controller;

import co.mercadolibre.SocialMeli.dto.response.ClientFollowedDTO;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.util.IntegrationData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Nested
    class FollowUser {
        @DisplayName("T0001: Follow user ok")
        @Test
        void followUserOkTest() throws Exception {
            int userId = 3;
            int userIdToFollow = 1;
            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("El usuario 3 ha seguido de manera exitosa al vendedor 1."))
                    .andExpect(jsonPath("$.status").value("OK"));
        }

        @DisplayName("T0001: Follow seller Not found")
        @Test
        void followNonExistingSellerTest() throws Exception {
            int userId = 3;
            int userIdToFollow = 55;
            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.message").value("No existe un vendedor con el id 55."))
                    .andExpect(jsonPath("$.status").value("NOT_FOUND"));
        }

        @DisplayName("T0001: User follows itself")
        @Test
        void followMyselfException() throws Exception {
            int userId = 1;
            int userIdToFollow = 1;
            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("El usuario 1 no se puede seguir a sí mismo."))
                    .andExpect(jsonPath("$.status").value("BAD_REQUEST"));
        }

    }


    @Test
    @DisplayName("T0003 - Lista seguidos - Camino malo, usuario no encontrado")
    public void listFollowedNotFoundSellerTest() throws Exception {

        int userId = 10;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El usuario con el id %d no se ha encontrado".formatted(userId)));

    }

}
