package ar.com.mercadolibre.socialmeli2.integration;

import ar.com.mercadolibre.socialmeli2.dto.requests.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.ProductDto;
import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.Post;
import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.repository.impl.PostRepositoryImpl;
import ar.com.mercadolibre.socialmeli2.repository.impl.UserRepositoryImpl;
import ar.com.mercadolibre.socialmeli2.dto.requests.PromoPostDto;
import ar.com.mercadolibre.socialmeli2.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    PostRepositoryImpl postRepository;

    @Autowired
    ObjectMapper mapper;

    private PromoPostDto promoPostDto;
    private PromoPostDto promoPostDtoIncorrect;
    private Post promoPost;
    private List<Follow> follows;
    private User user;

    @BeforeEach
    public void setUp() {
        promoPostDto = TestUtils.createPromoPostDto();
        promoPostDtoIncorrect = TestUtils.createPromoPostDtoIncorrect();
        promoPost = TestUtils.createPromoPost();
        follows = TestUtils.createUserFollows();
        user = follows.get(0).getUserToFollow();
    }

    @Test
    @DisplayName("US0005 - Create post test returns OK")
    public void createPostTestReturnsOk() throws Exception {
        PostDto postDto = new PostDto(
                1,
                LocalDate.now(),
                new ProductDto(1,
                        "Silla Gamer",
                        "Muebles",
                        "AeroCool",
                        "Red",
                        "Nueva"),
                1,
                100.0
        );

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postDto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US0005 - Create post test returns BAD REQUEST")
    public void createPostTestReturnsBadRequest() throws Exception {
        PostDto postDto = new PostDto(
                1,
                LocalDate.now(),
                new ProductDto(1,
                        "Silla Gamer",
                        "Muebles",
                        "AeroCool",
                        "",
                        "Nueva"),
                1,
                100.0
        );

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postDto)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Error de validación"));

    }

    @Test
    @DisplayName("US0005 - Create post test for a not seller returns OK")
    public void createPostTestForNotSellerReturnsBadRequest() throws Exception {
        user.setSeller(false);
        userRepository.save(user);

        PostDto postDto = new PostDto(
                1,
                LocalDate.now(),
                new ProductDto(1,
                        "Silla Gamer",
                        "Muebles",
                        "AeroCool",
                        "Red",
                        "Nueva"),
                1,
                100.0
        );

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postDto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US0010 - Add promo post test returns OK")
    public void addPromoPostTestReturnsOk() throws Exception {
        String promoPostJson = mapper.writeValueAsString(promoPostDto);

        MvcResult result = mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(
                promoPostDto.getUserId(),
                mapper.readTree(result.getResponse().getContentAsString()).get("user_id").asInt());
    }

    @Test
    @DisplayName("US0010 - Promo post with non-existent user should return 404")
    public void promoPostTestReturnsNotFoundExceptionNotExistsUser() throws Exception {
        promoPostDto.setUserId(99);
        String promoPostJson = mapper.writeValueAsString(promoPostDto);

        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("US0010 - Promo post with multiple validation errors should return 400")
    public void promoPostWithMultipleValidationErrorsShouldReturnBadRequest() throws Exception {
        String promoPostJson = mapper.writeValueAsString(promoPostDtoIncorrect);

        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Error de validación"))
                .andExpect(jsonPath("$.errors", hasSize(10)));
    }

    @Test
    @DisplayName("US0011 - Count promo post test returns OK")
    public void getPromoPostCountOk() throws Exception {
        userRepository.save(user);
        postRepository.save(promoPost);

        MvcResult result = mockMvc.perform(get("/products/promo-post/count")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(user.getId(), mapper.readTree(result.getResponse().getContentAsString()).get("user_id").asInt());
        assertEquals(1, mapper.readTree(result.getResponse().getContentAsString()).get("promo_products_count").asInt());

    }

    @Test
    @DisplayName("US0011 - Count promo post test returns not found exception while providing a non existent user")
    public void getPromoPostCountUserNotFound() throws Exception {
        String idNonExistent = "99";

        mockMvc.perform(get("/products/promo-post/count")
                        .param("userId", idNonExistent)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US0011 - Count promo post test returns validation exception when user is not a seller")
    public void getPromoPostCountUserNotSeller() throws Exception {
        user.setSeller(false);
        userRepository.save(user);

        mockMvc.perform(get("/products/promo-post/count")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Request with missing request param returns 400 Bad Request")
    public void requestWithMissingRequestParamReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", "4", "-1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Request with invalid JSON returns 400 Bad Request")
    public void requestWithInvalidJsonReturn400BadRequest() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"name\""))
                .andExpect(status().isBadRequest());
    }
}
