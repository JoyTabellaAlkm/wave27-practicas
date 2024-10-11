package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    @InjectMocks
    CalculateService calculateService ;

    @Test
    void calculateTest(){
        //Arrange
        RoomDTO room1 = new RoomDTO();
        room1.setName("cuarto 1");
        room1.setWidth(10);
        room1.setLength(12);

        RoomDTO room2 = new RoomDTO();
        room2.setName("cuarto 2");
        room2.setWidth(5);
        room2.setLength(5);

        RoomDTO room3 = new RoomDTO();
        room3.setName("baño");
        room3.setWidth(3);
        room3.setLength(4);

        HouseDTO houseRequest = new HouseDTO();
        houseRequest.setName("casa");
        houseRequest.setAddress("calle falsa 123");
        houseRequest.setRooms(List.of(room1, room2, room3));

        //Act
        HouseResponseDTO obtained = calculateService.calculate(houseRequest);

        //Assert
        Assertions.assertEquals(157, obtained.getSquareFeet());
        Assertions.assertEquals(125600, obtained.getPrice());
        Assertions.assertEquals(room1, obtained.getBiggest());
    }
}
