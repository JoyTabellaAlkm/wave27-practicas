package ar.com.mercadolibre.socialmeli.unit.controller;

import ar.com.mercadolibre.socialmeli.controller.UserController;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerListResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserOkResponseDTO;
import ar.com.mercadolibre.socialmeli.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("T-0001 - Success")
    void followASpecificUserByIdTest() {
        //Arrange
        UserOkResponseDTO userOk = userService.followASpecificUserById(1,2);
        when(userService.followASpecificUserById(1, 2)).thenReturn(userOk);

        // Act
        ResponseEntity<?> response = userController.followASpecificUserById(1, 2);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("T-0003 - Success name_asc")
    public void T003NameAscTest(){
        //arrange
        Integer userId = 1;
        when(userService.getFollowerList(userId, "name_asc")).thenReturn(new UserFollowerListResponseDTO());

        //act
        ResponseEntity<?> response = userController.getFollowerList(userId, "name_asc");

        //assert
        verify(userService, atLeastOnce()).getFollowerList(userId, "name_asc");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("T-0003 - Success name_desc")
    public void T003NameDescTest(){
        //arrange
        Integer userId = 1;
        when(userService.getFollowerList(userId, "name_desc")).thenReturn(new UserFollowerListResponseDTO());

        //act
        ResponseEntity<?> response = userController.getFollowerList(userId, "name_desc");

        //assert
        verify(userService, atLeastOnce()).getFollowerList(userId, "name_desc");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }



    @Test
    @DisplayName("T-0003 - Happy Path No ordering")
    public void getFollowerListTest() {
        //arrange
        Integer userId = 1;
        when(userService.getFollowerList(userId, null)).thenReturn(new UserFollowerListResponseDTO());

        //act
        ResponseEntity<?> response = userController.getFollowerList(userId, null);

        //assert
        verify(userService, atLeastOnce()).getFollowerList(userId, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}
