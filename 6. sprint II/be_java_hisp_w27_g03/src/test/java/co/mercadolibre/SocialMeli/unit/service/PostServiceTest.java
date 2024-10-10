package co.mercadolibre.SocialMeli.unit.service;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import co.mercadolibre.SocialMeli.dto.response.PostResponseDTO;
import co.mercadolibre.SocialMeli.dto.response.RecentPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import co.mercadolibre.SocialMeli.service.impl.PostService;
import co.mercadolibre.SocialMeli.service.impl.UserService;
import co.mercadolibre.SocialMeli.util.Data;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IUsersRepository iUsersRepository;
    @Mock
    GlobalMethods globalMethods;
    @Mock
    ObjectMapper mapper;
    @InjectMocks
    PostService postService;

    @Nested
    class PostsFollowed {
        @DisplayName("T-0005: Posts by Followed Users Last Two Weeks Ok")
        @Test
        void getPostsByFollowedUsersLastTwoWeeksOkTest() {
            //Arrange
            List<User> userList = Data.getUsersListTest();
            User user = userList.stream()
                    .filter(u -> u.getUserId() == 4)
                    .findFirst()
                    .orElse(null);
            List<PostResponseDTO> posts = user.getFollowed().stream()
                    .flatMap(p -> p.getPosts().stream())
                    .map(post -> Data.convertPostToPostResponseDTO(post))
                    .collect(Collectors.toList());

            posts.sort(Comparator.comparing(PostResponseDTO::getDate));
            RecentPostDTO mockOutDTO = new RecentPostDTO(
                    4,
                    posts
            );

            //Simulation
            when(iUsersRepository.findAllUsers()).thenReturn(userList);
            when(globalMethods.getUserById(4)).thenReturn(user);
            when(mapper.convertValue(any(Post.class), eq(PostResponseDTO.class)))
                    .thenReturn(posts.get(0))
                    .thenReturn(posts.get(1))
                    .thenReturn(posts.get(2));
            //Act
            RecentPostDTO obtained = postService.getPostsByFollowedUsersLastTwoWeeks(4, "date_asc");

            //Assert
            assertEquals(mockOutDTO, obtained);
            verify(iUsersRepository).findAllUsers();
            verify(globalMethods, times(2)).getUserById(anyInt());
        }

        @DisplayName("T-0005: Posts by Followed Users Last Two Weeks Bad Request")
        @Test
        void getPostsByFollowedUsersLastTwoWeeksNoOrderTest() {

            //Arrange
            ResponseDTO expectedResponse = new ResponseDTO("Orden no válido.", HttpStatus.BAD_REQUEST);
            List<User> userList = Data.getUsersListTest();
            User user = userList.stream()
                    .filter(u -> u.getUserId() == 4)
                    .findFirst()
                    .orElse(null);
            List<PostResponseDTO> posts = user.getFollowed().stream()
                    .flatMap(p -> p.getPosts().stream())
                    .map(post -> Data.convertPostToPostResponseDTO(post))
                    .collect(Collectors.toList());

            posts.sort(Comparator.comparing(PostResponseDTO::getDate));
            RecentPostDTO mockOutDTO = new RecentPostDTO(
                    4,
                    posts
            );

            //Simulation
            when(iUsersRepository.findAllUsers()).thenReturn(userList);
            when(globalMethods.getUserById(4)).thenReturn(user);
            when(mapper.convertValue(any(Post.class), eq(PostResponseDTO.class)))
                    .thenReturn(posts.get(0))
                    .thenReturn(posts.get(1))
                    .thenReturn(posts.get(2));

            //Act & Assert
            BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> postService.getPostsByFollowedUsersLastTwoWeeks(4, "prueba"));
            assertTrue(badRequestException.getMessage().contains(expectedResponse.getMessage()));
            verify(iUsersRepository).findAllUsers();
            verify(globalMethods, times(2)).getUserById(anyInt());

        }

        @DisplayName("T-0005: Posts by Followed Users Last Two Weeks Not Found")
        @Test
        void getPostsByFollowedUsersLastTwoWeeksNotFoundTest() {
            //Arrange
            ResponseDTO expectedResponse = new ResponseDTO("No hay usuarios registrados", HttpStatus.NOT_FOUND);

            //Simulation
            when(iUsersRepository.findAllUsers()).thenReturn(Collections.EMPTY_LIST);

            //Act & Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> postService.getPostsByFollowedUsersLastTwoWeeks(1, "prueba"));
            assertTrue(notFoundException.getMessage().contains(expectedResponse.getMessage()));
        }

    }

    @Nested
    class showPostLastTwoWeeks {
        @DisplayName("T0008: git Verificar que los post son unicamente de las últimas 2 semanas ")
        @Test
        void getPostsFromFollowedLastTwoWeeksTest() {
            //Arrange
            User client = Data.getUserThatFollows1Seller();
            int clientId = client.getUserId();

            Product product = new Product(1, "Mesedora", "Muebles", "Sillas jairo", "Blanco", "Realizada con madera de roble");
            ProductDTO productDTO = new ProductDTO(1, "Mesedora", "Muebles", "Sillas jairo", "Blanco", "Realizada con madera de roble");

            Post post = new Post(1, 2, LocalDate.parse("2024-10-09"), product, 1, 223.3);
            PostResponseDTO postDTO = new PostResponseDTO(1, 2, LocalDate.parse("2024-10-09"), productDTO, 1, 223.3);

            List<PostResponseDTO> expectedPosts = List.of(postDTO);

            //Act
            when(iUsersRepository.findAllUsers()).thenReturn(List.of(client));
            when(globalMethods.getUserById(clientId)).thenReturn(client);
            when(mapper.convertValue(post, PostResponseDTO.class)).thenReturn(postDTO);

            RecentPostDTO found = postService.getPostsByFollowedUsersLastTwoWeeks(clientId, null);

            //Assert
            verify(iUsersRepository).findAllUsers();
            verify(globalMethods, times(2)).getUserById(clientId);
            verify(mapper).convertValue(any(), eq(PostResponseDTO.class));

            Assertions.assertEquals(clientId, found.getUserId());
            Assertions.assertEquals(1, found.getRecentPosts().size());
            Assertions.assertEquals(expectedPosts, found.getRecentPosts());
        }
    }


    @Nested
    class OrderListFollowed {
        @DisplayName("T-0006: Posts by Followed Users Last Two Weeks Order ASC Ok")
        @Test
        void getPostsByASCTestOk() {
            //Arrange
            List<User> userList = Data.getUsersListTest();
            User user = userList.stream()
                    .filter(u -> u.getUserId() == 4)
                    .findFirst()
                    .orElse(null);
            List<PostResponseDTO> posts = user.getFollowed().stream()
                    .flatMap(p -> p.getPosts().stream())
                    .map(post -> Data.convertPostToPostResponseDTO(post))
                    .collect(Collectors.toList());

            posts.sort(Comparator.comparing(PostResponseDTO::getDate));
            RecentPostDTO mockOutDTO = new RecentPostDTO(
                    4,
                    posts
            );
            //Simulation
            when(iUsersRepository.findAllUsers()).thenReturn(userList);
            when(globalMethods.getUserById(4)).thenReturn(user);
            when(mapper.convertValue(any(Post.class), eq(PostResponseDTO.class)))
                    .thenReturn(posts.get(0))
                    .thenReturn(posts.get(1))
                    .thenReturn(posts.get(2));

            //Act
            RecentPostDTO obtained = postService.getPostsByFollowedUsersLastTwoWeeks(4, "date_asc");

            //Assert
            assertEquals(mockOutDTO, obtained);
            verify(iUsersRepository).findAllUsers();
            verify(globalMethods, times(2)).getUserById(anyInt());
        }

        @DisplayName("T-0006: Posts by Followed Users Last Two Weeks Order DESC Ok")
        @Test
        void getPostsByDESCTestOk() {
            //Arrange
            List<User> userList = Data.getUsersListTest();
            User user = userList.stream()
                    .filter(u -> u.getUserId() == 4)
                    .findFirst()
                    .orElse(null);
            List<PostResponseDTO> posts = user.getFollowed().stream()
                    .flatMap(p -> p.getPosts().stream())
                    .map(post -> Data.convertPostToPostResponseDTO(post))
                    .collect(Collectors.toList());

            posts.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
            RecentPostDTO mockOutDTO = new RecentPostDTO(
                    4,
                    posts
            );
            //Simulation
            when(iUsersRepository.findAllUsers()).thenReturn(userList);
            when(globalMethods.getUserById(4)).thenReturn(user);
            when(mapper.convertValue(any(Post.class), eq(PostResponseDTO.class)))
                    .thenReturn(posts.get(0))
                    .thenReturn(posts.get(1))
                    .thenReturn(posts.get(2));

            //Act
            RecentPostDTO obtained = postService.getPostsByFollowedUsersLastTwoWeeks(4, "date_desc");

            //Assert
            assertEquals(mockOutDTO, obtained);
            verify(iUsersRepository).findAllUsers();
            verify(globalMethods, times(2)).getUserById(anyInt());
        }
    }
}
