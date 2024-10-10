package ar.com.mercadolibre.socialmeli.integration;

import ar.com.mercadolibre.socialmeli.dto.response.UserFollowedResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerCountResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerListResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserNameResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper OBJECT_MAPPER;

    @BeforeAll
    public static void setUp() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        OBJECT_MAPPER = new ObjectMapper();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));

        OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        OBJECT_MAPPER.registerModule(javaTimeModule);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    @DisplayName("INTEGRATION - US - 04 - Find By Followed")
    public void findByFollowed() throws Exception{

        Integer userId = 2;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String jsonResponse =  mvcResult.getResponse().getContentAsString();
        UserFollowedResponseDTO[] userFollowedResponseDTOS = OBJECT_MAPPER.readValue(jsonResponse, UserFollowedResponseDTO[].class);

        List<UserFollowedResponseDTO> userFollowed = Arrays.stream(userFollowedResponseDTOS).toList();
        Assertions.assertNotNull(userFollowed);
        Assertions.assertFalse(userFollowed.isEmpty());

        boolean userIdFound = userFollowed.stream()
                .flatMap(userFollowedList -> userFollowedList.getFollowed().stream())
                .anyMatch(followedUser -> followedUser.getUserId() == 4);

        Assertions.assertTrue(userIdFound);
    }

    @Test
    @DisplayName("INTEGRATION - US - 04 - Find By Followed Sad Path 1")
    public void findByFollowedSad() throws Exception{


        Integer userId = 3;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User with the ID: 3 is not following anyone."))
                .andReturn();
    }

    @Test
    @DisplayName("INTEGRATION - US - 04 - Find By Followed Sad Path 2")
    public void findByFollowedSad2() throws Exception{

        Integer userId = 7;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User ID: " + userId + " doesn't exist."))
                .andReturn();
    }


    @Test
    @DisplayName("INTEGRATION - US - 04 - Find By Followed Sad Path 3")
    public void findByFollowedSad3() throws Exception{

        Integer userId = 2;
        String order = "assad";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).param("order", order)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Invalid order parameter: "+ order))
                .andReturn();
    }


    @DisplayName("INTEGRATION - US - 02 - Counts more than Zero")
    @Test
    void integrationTestGetFollowersCountsMoreThanZero() throws Exception {

        //Arrange
        Integer userId = 4;

        //Act & Assert
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserFollowerCountResponseDTO response = OBJECT_MAPPER.readValue(jsonResponse, UserFollowerCountResponseDTO.class);


        assertNotNull(response);
        assertEquals(2, response.getFollowersCount());
        assertEquals("Maria Emilia", response.getUserName());
        assertEquals(4, response.getUserId());
    }

    @DisplayName("INTEGRATION - US - 02 - Counts Zero")
    @Test
    void integrationTestGetFollowersCountsZero() throws Exception {

        //Arrange
        Integer userId = 1;

        //Act & Assert
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserFollowerCountResponseDTO response = OBJECT_MAPPER.readValue(jsonResponse, UserFollowerCountResponseDTO.class);


        assertNotNull(response);
        assertEquals(0, response.getFollowersCount());
        assertEquals("Fernando Baldrich", response.getUserName());
        assertEquals(1, response.getUserId());
    }

    @DisplayName("INTEGRATION - US - 02 - Negative User ID")
    @Test
    void integrationTestNegativeUserId() throws Exception {

        // Arrange
        Integer userId = -1;
        String expectedJson = "[{\"argument\":\"getFollowersCount.userId\",\"message\":\"El id debe ser mayor a cero.\",\"rejected_value\":-1}]";

        // Act & Assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andExpect(status().isBadRequest())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedJson, jsonResponse);
    }

    @DisplayName("INTEGRATION - US - 03 - Gets list more than zero")
    @Test
    void integrationTestGetFollowersListMoreThanZero() throws Exception {

        //Arrange
        Integer userId = 4;
        UserNameResponseDTO follower1 = new UserNameResponseDTO(5, "Delfina Glavas");
        UserNameResponseDTO follower2 = new UserNameResponseDTO(2, "Matias Gregorat");


        //Act & Assert
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserFollowerListResponseDTO response = OBJECT_MAPPER.readValue(jsonResponse, UserFollowerListResponseDTO.class);


        assertNotNull(response);
        assertEquals(2, response.getFollowers().size());
        assertTrue(response.getFollowers().contains(follower1));
        assertTrue(response.getFollowers().contains(follower2));
        assertEquals("Maria Emilia", response.getUserName());
        assertEquals(4, response.getUserId());
    }

    @DisplayName("INTEGRATION - US - 03 - Gets list more than zero")
    @Test
    void integrationTestGetFollowersListZero() throws Exception {

        //Arrange
        Integer userId = 1;

        //Act & Assert
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserFollowerListResponseDTO response = OBJECT_MAPPER.readValue(jsonResponse, UserFollowerListResponseDTO.class);


        assertNotNull(response);
        assertEquals(1, response.getUserId());

    }

    @DisplayName("INTEGRATION - US - 03 - Negative User ID")
    @Test
    void integrationTestGetFollowersListNegativeUserId() throws Exception {

        // Arrange
        Integer userId = -1;
        String expectedJson = "[{\"argument\":\"getFollowerList.userId\",\"message\":\"El id debe ser mayor a cero.\",\"rejected_value\":-1}]";

        // Act & Assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andExpect(status().isBadRequest())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedJson, jsonResponse);
    }


    @Test
    @DisplayName("INTEGRATION - US - 07 - happyPath")
    public void unfollowASpecificUserByIdTest() throws Exception {
        // Arrange
        Integer userId = 5;
        Integer userIdToUnfollow = 2;
        String jsonResponse = "{\"response\":\"OK\"}";

        // Act
        MvcResult response= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonResponse))
                .andReturn();

        String jResponse =  response.getResponse().getContentAsString();

        // Assert
        assertNotNull(jResponse);
        assertEquals(jsonResponse, jResponse);

    }


    @Test
    @DisplayName("INTEGRATION - US - 07 - sadPath - UnfollowIdNotExist")
    public void unfollowASpecificUserByIdTestB1() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToUnfollow = 2;
        String jsonResponse = "{\"message\":\"Invalid User and User ID to unfollow\"}";

        // Act
        MvcResult response= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(jsonResponse))
                .andReturn();

        String jResponse =  response.getResponse().getContentAsString();

        // Assert
        assertNotNull(jResponse);
        assertEquals(jsonResponse, jResponse);

    }

    @Test
    @DisplayName("INTEGRATION - US - 07 - sadPath - userIdNotExist")
    public void unfollowASpecificUserByIdTestB2() throws Exception {
        // Arrange
        Integer userId = 10;
        Integer userIdToUnfollow = 2;
        String jsonResponse = "{\"message\":\"Invalid User ID: 10\"}";

        // Act
        MvcResult response= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonResponse))
                .andReturn();

        String jResponse =  response.getResponse().getContentAsString();

        // Assert
        assertNotNull(jResponse);
        assertEquals(jsonResponse, jResponse);

    }

    @Test
    @DisplayName("INTEGRATION - US - 01 - User Follow")
    public void integrationFollowASpecificUserById() throws Exception {
        //Arrange
        Integer userId = 1;
        Integer followerId = 2;
        String jsonResponse = "{\"response\":\"OK\"}";
        //Act
        MvcResult response= mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, followerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonResponse))
                .andReturn();

        String jResponse =  response.getResponse().getContentAsString();

        // Assert
        assertNotNull(jResponse);
        assertEquals(jsonResponse, jResponse);
    }


}
