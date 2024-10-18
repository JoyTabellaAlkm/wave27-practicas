package co.mercadolibre.SocialMeli.unit.service;

import co.mercadolibre.SocialMeli.dto.response.CountFollowersDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ExceptionDTO;
import co.mercadolibre.SocialMeli.dto.response.SellerFollowersDTO;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import co.mercadolibre.SocialMeli.service.impl.SellerService;
import co.mercadolibre.SocialMeli.util.Data;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    @Mock
    IUsersRepository usersRepository;
    @Mock
    GlobalMethods globalMethods;

    @InjectMocks
    SellerService sellerService;

    @Nested
    class userOrderListT0004 {
        @DisplayName("T-0004: Listar seguidores por orden ascendente")
        @Test
        public void listFollowersTestOrderAsc() {
            //Arrange
            int userId = 1;
            String order = "name_asc";
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null); //traer el vendedor numero 1
            SellerFollowersDTO expectedListFollowers = Data.getlistFollowersAscTest(); //traer lista ordenada

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);
            SellerFollowersDTO listFollowersByOrderAsc = sellerService.listFollowers(userId, order);

            //Assert
            assertEquals(expectedListFollowers, listFollowersByOrderAsc);
            verify(usersRepository).findAllUsers();
        }

        @DisplayName("T-0004: Listar seguidores por orden descendente")
        @Test
        public void listFollowersTestOrderDesc() {
            //Arrange
            int userId = 1;
            String order = "name_desc";
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null); //traer el vendedor numero 1
            SellerFollowersDTO expectedListFollowers = Data.getlistFollowersDescTest(); //traer lista ordenada

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);
            SellerFollowersDTO listFollowersByOrderDesc = sellerService.listFollowers(userId, order);

            //Assert
            assertEquals(expectedListFollowers, listFollowersByOrderDesc);
            verify(usersRepository).findAllUsers();
        }

        @DisplayName("T-0004: Orden invalido")
        @Test
        public void listFollowersTestOrderInvalid() {
            //Arrange
            int userId = 1;
            String order = "name";
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null); //traer el vendedor numero 1
            ExceptionDTO expectedResponse = new ExceptionDTO("Ordenamiento inválido", HttpStatus.BAD_REQUEST);

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);

            //Assert
            BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> sellerService.listFollowers(userId, order));
            assertTrue(badRequestException.getMessage().contains(expectedResponse.getMessage()));
            verify(usersRepository).findAllUsers();
        }

    }

    @Nested
    class CountFollowersT0007 {
        @DisplayName("T-0007: Contar seguidores")
        @Test
        void countFollowersOkTest() {
            //Arrange
            int userId = 1;
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null); //traer el vendedor numero 1
            CountFollowersDTO expectedCount = Data.getCountFollowers(); //traer el número de seguidores

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);
            CountFollowersDTO countFollowers = sellerService.countFollowers(userId);

            //Assert
            assertEquals(expectedCount, countFollowers);
            verify(usersRepository).findAllUsers();

        }

        @DisplayName("T-0007: No se encuentra el usuario")
        @Test
        void countFollowersNotUserFoundTest() {
            //Arrange
            int userId = 8;
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = null; //traer vendedor nulo
            ExceptionDTO expectedResponse = new ExceptionDTO("El usuario con el id 8 no se ha encontrado", HttpStatus.NOT_FOUND);

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);

            //Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> sellerService.countFollowers(userId));
            assertTrue(notFoundException.getMessage().contains(expectedResponse.getMessage()));
            verify(usersRepository).findAllUsers();
            verify(globalMethods, never()).isNotSeller(any(User.class));
        }

        @DisplayName("T-0007: El usuario no es vendedor")
        @Test
        void countFollowersNotSellerTest() {
            //Arrange
            int userId = 5;
            List<User> usersList = Data.getUsersListTest(); //traer datos precargados
            User userSeller = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null); //traer vendedor nulo
            ExceptionDTO expectedResponse = new ExceptionDTO("El usuario con el id 5 no es un vendedor", HttpStatus.NOT_FOUND);

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.isNotSeller(userSeller)).thenReturn(true);
            when(globalMethods.getUserById(userId)).thenReturn(userSeller);

            //Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> sellerService.countFollowers(userId));
            assertTrue(notFoundException.getMessage().contains(expectedResponse.getMessage()));
            verify(usersRepository).findAllUsers();
            verify(globalMethods).isNotSeller(any(User.class));
        }

        @DisplayName("T-0007: No hay usuarios registrados")
        @Test
        void countFollowersNotUsersTest() {
            //Arrange
            int userId = 1;
            List<User> usersList = new ArrayList<>(); //traer datos precargados
            User userSeller = null; //traer vendedor nulo
            ExceptionDTO expectedResponse = new ExceptionDTO("No hay usuarios registrados", HttpStatus.NOT_FOUND);

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);

            //Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> sellerService.countFollowers(userId));
            assertTrue(notFoundException.getMessage().contains(expectedResponse.getMessage()));
            verify(usersRepository).findAllUsers();
            verify(globalMethods, never()).isNotSeller(any(User.class));
        }
    }

    @Nested
    class T0003 {
        @DisplayName("Ordenar seguidores - Camino Bueno")
        @Test
        void orderingFollowersGood() {

            //Arrange
            int userId = 1;
            String order = null;
            List<User> usersList = Data.getUsersListTestT0003();
            User userById = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);

            SellerFollowersDTO expectedJson = Data.getlistFollowersSellersTest();


            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userById);
            when(globalMethods.isNotSeller(userById)).thenReturn(false);

            SellerFollowersDTO serviceResponse = sellerService.listFollowers(userId, order);

            //Assert
            Assertions.assertEquals(expectedJson, serviceResponse);
            verify(globalMethods).getUserById(anyInt());
            verify(globalMethods).isNotSeller(any(User.class));

        }

        @DisplayName("Ordenar seguidores - Camino Malo, no hay ususarios")
        @Test
        void orderingFollowersBadUsers() {

            //Arrange
            int userId = 1;
            String order = null;
            User userById = null;
            List<User> usersList = new ArrayList<>();

            //Act & Assert
            when(usersRepository.findAllUsers()).thenReturn(usersList);

            NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> {
                sellerService.listFollowers(userId, order);
            });

            Assertions.assertEquals("No hay usuarios registrados", notFoundException.getMessage());
            verify(globalMethods, never()).getUserById(anyInt());
            verify(globalMethods, never()).isNotSeller(any(User.class));

        }

        @DisplayName("Ordenar seguidores - Camino Malo, no encuentra al vendedor")
        @Test
        void orderingFollowersBadSeller() {

            //Arrange
            int userId = 1;
            String order = null;
            User userById = null;
            List<User> usersList = Data.getUsersListTestT0003();

            //Act & Assert
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userById);

            NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> {
                sellerService.listFollowers(userId, order);
            });

            Assertions.assertEquals("El usuario con el id %d no se ha encontrado".formatted(userId), notFoundException.getMessage());
            verify(globalMethods).getUserById(anyInt());
            verify(globalMethods, never()).isNotSeller(any(User.class));

        }

        @DisplayName("Ordenar seguidores - Camino Malo, el usuario no es vendedor")
        @Test
        void orderingFollowersBadFindUser() {

            //Arrange
            int userId = 1;
            String order = null;
            List<User> usersList = Data.getUsersListTestT0003();
            User userById = usersList.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);

            //Act & Assert
            when(usersRepository.findAllUsers()).thenReturn(usersList);
            when(globalMethods.getUserById(userId)).thenReturn(userById);
            when(globalMethods.isNotSeller(userById)).thenReturn(true);

            NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> {
                sellerService.listFollowers(userId, order);
            });

            Assertions.assertEquals("El usuario con el id %d no es un vendedor".formatted(userId), notFoundException.getMessage());
            verify(globalMethods).getUserById(anyInt());
            verify(globalMethods).isNotSeller(any(User.class));

        }

    }

    @Nested
    class Bonus {
        @Test
        @DisplayName("Lista vendedores mas activos - Camino bueno")
        public void listMostActiveSellersGoodTest() throws Exception {

            //Arrange
            List<User> usersList = Data.getUsersListTest();

            String expectedJson = "[{\"user_id\":3,\"user_name\":\"AngelaDaza\",\"post_count\":1},{\"user_id\":2,\"user_name\":\"VaneLozano\",\"post_count\":1},{\"user_id\":1,\"user_name\":\"LeandroRamirez\",\"post_count\":1}]";
            ObjectWriter writer = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);

            List<CountPostDTO> serviceResponse = sellerService.listMostActiveSellers();
            String responseJson = writer.writeValueAsString(serviceResponse);

            //Assert
            Assertions.assertEquals(expectedJson, responseJson);

        }

        @Test
        @DisplayName("Lista vendedores mas activos - Camino bueno")
        public void listMostActiveSellersNoUsersTest() throws Exception {

            //Arrange
            List<User> usersList = new ArrayList<>();

            //Act
            when(usersRepository.findAllUsers()).thenReturn(usersList);

            NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> {
                sellerService.listMostActiveSellers();
            });

            //Assert
            Assertions.assertEquals("No hay usuarios registrados.", notFoundException.getMessage());

        }
    }

}
