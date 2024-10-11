package co.mercadolibre.SocialMeli.unit.service;
import co.mercadolibre.SocialMeli.dto.request.PromoPostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;
import co.mercadolibre.SocialMeli.entity.Post;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.dto.response.CountPromoPostDTO;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.BadRequestException;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import co.mercadolibre.SocialMeli.service.impl.PromoPostService;
import co.mercadolibre.SocialMeli.util.Data;
import co.mercadolibre.SocialMeli.utils.GlobalMethods;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PromoPostServiceTest {
    @Mock
    IUsersRepository usersRepository;

    @Mock
    GlobalMethods globalMethods;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    PromoPostService promoPostService;
    @Nested
    class PostPromotion{
        @DisplayName("Test Extra : Post promotion ok")
        @Test
        void PostPromotionOkTest() {
            //Arrange
            PromoPostRequestDTO promoPostRequestDTO = Data.createPromoPost();
            Post post = Data.createPost();
            User user = Data.createSeller(1, "AndresMarquez");
            ResponseDTO expectedResponse = new ResponseDTO("Promocion creada: " + promoPostRequestDTO.getProduct().getProductName() + " por " + user.getUserName(), HttpStatus.OK);

            //Simulation
            when(usersRepository.findAllUsers()).thenReturn(List.of(user));
            when(mapper.convertValue(promoPostRequestDTO, Post.class)).thenReturn(post);
            when(usersRepository.findAllUsers()).thenReturn(List.of(user));
            when(globalMethods.verifyProduct(post.getProduct())).thenReturn(true);
            // Usar doAnswer para simular el comportamiento del método createPost
            doAnswer(invocation -> {
                Post argPost = invocation.getArgument(0);
                User argUser = invocation.getArgument(1);
                argUser.getPosts().add(argPost);
                return argUser.getPosts();
            }).when(usersRepository).createPost(any(Post.class), any(User.class));

            //Act
            ResponseDTO realResponse = promoPostService.postPromotion(promoPostRequestDTO);

            //Assert
            assertEquals(expectedResponse, realResponse);
            verify(usersRepository, times(2)).findAllUsers();
            verify(mapper).convertValue(promoPostRequestDTO,Post.class);
            verify(globalMethods).verifyProduct(any(Product.class));
            verify(usersRepository).createPost(any(Post.class), any(User.class));
        }
        @DisplayName("Test Extra : Post promotion user not found")
        @Test
        void PostPromotionUserNotFoundTest() {
            //Arrange
            PromoPostRequestDTO promoPostRequestDTO = Data.createPromoPost();
            User user = Data.createSeller(6, "AndresMarquez");
            ResponseDTO expectedResponse = new ResponseDTO("El usuario suministrado no existe", HttpStatus.NOT_FOUND);

            //Simulation
            when(usersRepository.findAllUsers()).thenReturn(List.of(user));

            //Act & Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, ()->{
                promoPostService.postPromotion(promoPostRequestDTO);
            });
            assertEquals(expectedResponse.getMessage(), notFoundException.getMessage());
            verify(usersRepository, times(2)).findAllUsers();

        }
    }


    @Nested
    class CountPromoPost{
        @DisplayName("T-0009: Contar post en promoción Ok")
        @Test
        void countPromoPostOk(){
            //Arrange
            User seller = Data.getSellerWithPromoPost();
            int userId = seller.getUserId();
            CountPromoPostDTO expected = new CountPromoPostDTO(userId, seller.getUserName(), 1);

            //Act
            when(usersRepository.findAllUsers()).thenReturn(List.of(seller));
            CountPromoPostDTO found = promoPostService.countPromoPostUser(userId);

            //Assert
            Assertions.assertEquals(expected, found);

        }

        @DisplayName("T-0009: El usuario no es un vendedor")
        @Test
        void countPromoPostNotSeller(){
            //Arrange
            User seller = Data.createUser(1, "JuanPerez");
            int userId = seller.getUserId();
            String expected = "El usuario 1 no es un vendedor";

            //Act
            when(usersRepository.findAllUsers()).thenReturn(List.of(seller));

            //Assert
            BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> promoPostService.countPromoPostUser(userId));
            assertTrue(badRequestException.getMessage().contains(expected));
        }

        @DisplayName("T-0009: El id no existe")
        @Test
        void countPromoPostNotFound(){
            //Arrange
            User seller = Data.createUser(1, "JuanPerez");
            int userId = 2;
            String expected = "Usuario no encontrado";

            //Act
            when(usersRepository.findAllUsers()).thenReturn(List.of(seller));

            //Assert
            NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> promoPostService.countPromoPostUser(userId));
            assertTrue(notFoundException.getMessage().contains(expected));
        }
    }

}
