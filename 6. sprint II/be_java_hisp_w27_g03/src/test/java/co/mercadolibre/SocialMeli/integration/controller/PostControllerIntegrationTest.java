package co.mercadolibre.SocialMeli.integration.controller;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import co.mercadolibre.SocialMeli.dto.response.PostResponseDTO;
import co.mercadolibre.SocialMeli.dto.response.RecentPostDTO;
import co.mercadolibre.SocialMeli.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Nested
    class showLastTwoWeeksPost {

        @DisplayName("TI0008: Muestra unicamente los post de las últimas 2 semanas")
        @Test
        void getPostByUserLastTwoWeeksTest() throws Exception {
            ProductDTO product = new ProductDTO(1, "Mesedora", "Muebles", "Sillas jairo", "Blanco", "Realizada con madera de roble");
            RecentPostDTO responseDTO = new RecentPostDTO(2, List.of(new PostResponseDTO(1, 1, LocalDate.parse("2024-10-03"), product, 1, 223.3)));

            ObjectWriter writer = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            String responseJson = writer.writeValueAsString(responseDTO);

            MvcResult result = mockMvc.perform(get("/products/followed/2/list")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
        }

    }

    @Nested
    class withFilterOrder{

        @DisplayName("TI0006: Muestra los post de las últimas 2 semanas ordenados según el DESC")
        @Test
        void postWithOrderDESC() throws Exception{

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            MvcResult result = mockMvc.perform(get("/products/followed/2/list")
                            .param("order", "date_desc")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.user_id").value(2))
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResult = result.getResponse().getContentAsString();

            RecentPostDTO recentPostDTO = mapper.readValue(jsonResult, RecentPostDTO.class);

            List<PostResponseDTO> expectRecentPost = recentPostDTO.getRecentPosts();
            expectRecentPost.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());

            Assertions.assertEquals(expectRecentPost, recentPostDTO.getRecentPosts());
        }

        @DisplayName("TI0006: Muestra los post de las últimas 2 semanas ordenados según el ASC")
        @Test
        void postWithOrderASC() throws Exception{

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            MvcResult result = mockMvc.perform(get("/products/followed/2/list")
                            .param("order", "date_asc")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.user_id").value(2))
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResult = result.getResponse().getContentAsString();

            RecentPostDTO recentPostDTO = mapper.readValue(jsonResult, RecentPostDTO.class);

            List<PostResponseDTO> expectRecentPost = recentPostDTO.getRecentPosts();
            expectRecentPost.sort(Comparator.comparing(PostResponseDTO::getDate));

            Assertions.assertEquals(expectRecentPost, recentPostDTO.getRecentPosts());
        }
    }
}
