package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculateServiceTest {
    private final int LIVING_ROOM = 0;
    private List<RoomDTO> rooms = new ArrayList<>();
    private HouseDTO houseDto;
    @Autowired
    private CalculateService calculateService;

    public void createMockRoomsList() {
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        room1.setWidth(5);
        room1.setLength(4);
        rooms.add(room1);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Bedroom");
        room2.setWidth(4);
        room2.setLength(3);
        rooms.add(room2);

        RoomDTO room3 = new RoomDTO();
        room3.setName("Kitchen");
        room3.setWidth(3);
        room3.setLength(2);
        rooms.add(room3);
    }

    public void createHouseDto() {
        createMockRoomsList();
        houseDto = new HouseDTO(
                "Murder House",
                "Transilvania 123",
                rooms
        );
    }

    @Test
    public void calculateOk() {
        // Arrange
        createHouseDto();
        HouseResponseDTO expectedResult = new HouseResponseDTO(38, 30400, rooms.get(LIVING_ROOM));

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDto);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void calculateWrongSquareFeet() {
        // Arrange
        createHouseDto();
        HouseResponseDTO expectedResult = new HouseResponseDTO(35, 30400, rooms.get(LIVING_ROOM));

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDto);

        // Assert
        Assertions.assertNotEquals(expectedResult.getSquareFeet(), result.getSquareFeet());
    }

    @Test
    public void calculateWrongPrice() {
        // Arrange
        createHouseDto();
        HouseResponseDTO expectedResult = new HouseResponseDTO(38, 3400, rooms.get(LIVING_ROOM));

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDto);

        // Assert
        Assertions.assertNotEquals(expectedResult.getPrice(), result.getPrice());
    }

    @Test
    public void calculateWrongBiggest() {
        // Arrange
        createHouseDto();
        HouseResponseDTO expectedResult = new HouseResponseDTO(38, 30400, rooms.get(1));

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDto);

        // Assert
        Assertions.assertNotEquals(expectedResult.getBiggest(), result.getBiggest());
    }
}
