package ar.com.mercadolibre.socialmeli2.integration;

import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.entity.Post;
import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.repository.impl.FollowRepositoryImpl;
import ar.com.mercadolibre.socialmeli2.repository.impl.PostRepositoryImpl;
import ar.com.mercadolibre.socialmeli2.repository.impl.UserRepositoryImpl;
import ar.com.mercadolibre.socialmeli2.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    FollowRepositoryImpl followRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private PostRepositoryImpl postRepository;

    private List<Follow> follows;

    @BeforeEach
    public void setUp() {
        follows = TestUtils.createUserFollows();
    }

    @Test
    @DisplayName("US0001 - Follow user test returns OK")
    public void followUserTestReturnsOk() throws Exception {
        User follower = follows.get(0).getUser();
        User followed = follows.get(0).getUserToFollow();

        boolean saved = userRepository.save(followed);

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(saved);
        assertEquals(
                follower.getId(),
                mapper.readTree(result.getResponse().getContentAsString()).get("user_id").asInt());
    }

    @Test
    @DisplayName("US0001 - Follow user test returns validation exception while trying to follow himself")
    public void followUserTestReturnsValidationException() throws Exception {
        User follower = follows.get(0).getUser();
        User followed = follows.get(0).getUser();

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("US0001 - Follow user test returns not found exception while providing a non existent user")
    public void followUserTestReturnsNotFound() throws Exception {
        User follower = new User(99, "User not found");
        User followed = follows.get(0).getUserToFollow();

        userRepository.save(followed);

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US0001 - Follow user test returns validation exception while trying to follow a non existent seller")
    public void followUserTestReturnsNotFoundSeller() throws Exception {
        User follower = follows.get(0).getUser();
        User followed = new User(99, "User not found");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("US0001 - Follow user test returns validation exception while trying to follow a non seller user")
    public void followUserTestReturnsValidationExceptionNotSeller() throws Exception {
        User follower = follows.get(0).getUser();
        User followed = follows.get(0).getUserToFollow();
        followed.setSeller(false);

        userRepository.save(followed);

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("US0001 - Follow user test returns validation exception while trying to follow a user already followed")
    public void followUserTestReturnsValidationExceptionAlreadyFollowed() throws Exception {
        User follower = follows.get(0).getUser();
        User followed = follows.get(0).getUserToFollow();

        Follow follow = new Follow(follower, followed);
        followRepository.save(follow);

        userRepository.save(followed);

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", follower.getId(), followed.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("BONUS - GET /users/top-10")
    public void getTop10UsersTest() throws Exception {
        List<User> users = new ArrayList<>();
        users.addAll(follows.stream().map(Follow::getUser).toList());
        users.addAll(follows.stream().map(Follow::getUserToFollow).toList());
        users.add(new User(6, "Jorge Juarez", true));

        users.stream().distinct().forEach(userRepository::save);
        follows.forEach(followRepository::save);
        postRepository.save(new Post(1, follows.get(2).getUserToFollow(), null, LocalDate.now(), 100.0, false, 0.0));

        mockMvc.perform(get("/users/top-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // First place - 2 followers
                .andExpect(jsonPath("$[0].user_id").value(1))
                .andExpect(jsonPath("$[0].user_name").value("Juan Perez"))
                .andExpect(jsonPath("$.[0].followers_count").value(2))
                .andExpect(jsonPath("$.[0].posts_count").value(0))
                // Second place - 1 follower + 1 post
                .andExpect(jsonPath("$[1].user_id").value(3))
                .andExpect(jsonPath("$[1].user_name").value("Carlos Marquez"))
                .andExpect(jsonPath("$.[1].followers_count").value(1))
                .andExpect(jsonPath("$.[1].posts_count").value(1))
                // Third place - 1 follower + 0 posts
                .andExpect(jsonPath("$[2].user_id").value(2))
                .andExpect(jsonPath("$[2].user_name").value("Maria Lopez"))
                .andExpect(jsonPath("$.[2].followers_count").value(1))
                .andExpect(jsonPath("$.[2].posts_count").value(0))
                // Fourth place - 0 followers
                .andExpect(jsonPath("$[3].user_id").value(6))
                .andExpect(jsonPath("$[3].user_name").value("Jorge Juarez"))
                .andExpect(jsonPath("$.[3].followers_count").value(0))
                .andExpect(jsonPath("$.[3].posts_count").value(0));
    }

    @Test
    @DisplayName("Request with empty path variable returns 400 Bad Request")
    public void requestWithEmptyPathVariableReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", "4", "")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Request with wrong type path variable returns 400 Bad Request")
    public void requestWithWrongTypePathVariableReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", "4", "verdura")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Request with invalid path variable returns 400 Bad Request")
    public void requestWithInvalidPathVariableReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", "4", "-1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Request with invalid path variable returns 405 Method Not Allowed")
    public void requestWithInvalidMethodReturns405MethodNotAllowed() throws Exception {
        mockMvc.perform(get("/products/promo-post/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
