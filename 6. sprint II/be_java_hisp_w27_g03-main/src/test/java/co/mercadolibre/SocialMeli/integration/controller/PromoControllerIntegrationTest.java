package co.mercadolibre.SocialMeli.integration.controller;

import co.mercadolibre.SocialMeli.dto.response.CountPostDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPromoPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.LazyInitializationExcludeFilter;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PromoControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Nested
    class countPromoPostUser {
        @DisplayName("TI0009: Devuelve correctamente el número de post en promoción")
        @Test
        void countPromoPostOk() throws Exception{
            CountPromoPostDTO expected = new CountPromoPostDTO(1, "JuanPerez", 0);
            int userId = 1;

            ObjectWriter writer = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            String expectedJson = writer.writeValueAsString(expected);

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count", userId)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("userId", "1"))
                    .andExpect(status().isOk())
                    .andReturn();

            Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
        }

        @DisplayName("TI0009: No es un vendedor")
        @Test
        void countPromoPostBadRequest() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("userId", "4"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("El usuario 4 no es un vendedor"))
                    .andExpect(jsonPath("$.status").value("BAD_REQUEST"));

        }

        @DisplayName("TI0009: Id no encontrado")
        @Test
        void countPromoPostNotFound() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("userId", "55"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.message").value("Usuario no encontrado"))
                    .andExpect(jsonPath("$.status").value("NOT_FOUND"));

        }
    }

    @Nested
    class createPromoPost{
        @DisplayName("TI0011: Crea un post con promoción")
        @Test
        void createPromoPostOk() throws Exception{
            CountPromoPostDTO expected = new CountPromoPostDTO(1, "JuanPerez", 0);
            int userId = 1;

            ObjectWriter writer = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            String expectedJson = writer.writeValueAsString(expected);

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count", userId)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("userId", "1"))
                    .andExpect(status().isOk())
                    .andReturn();

            Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
        }
    }
}
