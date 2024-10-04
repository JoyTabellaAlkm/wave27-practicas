package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    RoomDTO room1 = new RoomDTO();
    RoomDTO room2 = new RoomDTO();
    RoomDTO room3 = new RoomDTO();

    HouseDTO houseDTO = new HouseDTO();
    HouseResponseDTO houseResponseDTO;

    @BeforeEach
    public void setUp(){
        // Crear habitaciones
        // La mas grande
        room1.setName("Living Room");
        room1.setWidth(5);
        room1.setLength(4);


        room2.setName("Bedroom");
        room2.setWidth(4);
        room2.setLength(3);

        // La mas chica
        room3.setName("Kitchen");
        room3.setWidth(3);
        room3.setLength(3);

        // Crear casa y agregar habitaciones

        houseDTO.setName("My House");
        houseDTO.setAddress("123 Main St");
        houseDTO.setRooms(Arrays.asList(room1, room2, room3));

        houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setSquareFeet(41);
        houseResponseDTO.setPrice(41*800);
    }

    @Test
    public void calculateTotalSquareFoot() throws Exception{

        //Arrange
        Integer expected = houseResponseDTO.getSquareFeet();
        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        //Act
        HouseResponseDTO result = controller.calculate(houseDTO);

        //Assert
        assertEquals(expected, result.getSquareFeet());
    }

    @Test
    public void getBiggestRoomOk() throws Exception{
        //Arrange
        RoomDTO expected = room1;
        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        //Act
        HouseResponseDTO result = controller.calculate(houseDTO);

        //Assert
        assertEquals(expected, result.getBiggest());
    }

    @Test
    public void getSquareFootPerRoomOK() throws Exception{
        //Arrange
        Integer expectedr1 = room1.getSquareFeet();
        Integer expectedr2 = room2.getSquareFeet();
        Integer expectedr3 = room3.getSquareFeet();

        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        //Act
        HouseResponseDTO result = controller.calculate(houseDTO);

        //Assert
        assertEquals(expectedr1, result.getRooms().get(0).getSquareFeet());
        assertEquals(expectedr2, result.getRooms().get(1).getSquareFeet());
        assertEquals(expectedr3, result.getRooms().get(2).getSquareFeet());
    }

    @Test
    public void calculateTotalPrice() throws Exception {
        // Arrange
        Integer expectedPrice = houseResponseDTO.getPrice();
        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        // Act
        HouseResponseDTO result = controller.calculate(houseDTO);

        // Assert
        assertEquals(expectedPrice, result.getPrice());
    }

    @Test
    public void verifyRoomList() throws Exception {
        // Arrange
        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        // Act
        HouseResponseDTO result = controller.calculate(houseDTO);

        // Assert
        assertEquals(houseDTO.getRooms(), result.getRooms());
    }

    @Test
    public void handleHouseWithDuplicateRooms() throws Exception {
        // Arrange
        HouseDTO duplicateHouseDTO = new HouseDTO();
        duplicateHouseDTO.setName("Duplicate House");
        duplicateHouseDTO.setAddress("789 Duplicate St");
        duplicateHouseDTO.setRooms(Arrays.asList(room1, room1, room2));
        HouseResponseDTO duplicateHouseResponseDTO = new HouseResponseDTO(duplicateHouseDTO);
        duplicateHouseResponseDTO.setSquareFeet(room1.getSquareFeet() * 2 + room2.getSquareFeet());
        duplicateHouseResponseDTO.setPrice((room1.getSquareFeet() * 2 + room2.getSquareFeet()) * 800);
        when(service.calculate(duplicateHouseDTO)).thenReturn(duplicateHouseResponseDTO);

        // Act
        HouseResponseDTO result = controller.calculate(duplicateHouseDTO);

        // Assert
        assertEquals(duplicateHouseResponseDTO.getSquareFeet(), result.getSquareFeet());
        assertEquals(duplicateHouseResponseDTO.getPrice(), result.getPrice());
        assertEquals(3, result.getRooms().size());
    }
}
