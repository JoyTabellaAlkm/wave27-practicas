package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    @DisplayName("Calcular valor correcto de la propiedad basado en los metros cuadrados")
    public void testCalculatePrice() {
        CalculateService calculateService = new CalculateService();

        HouseDTO houseDTO = HouseDTO.builder()
                .name("Casa de Prueba")
                .address("Calle Falsa 123")
                .rooms(List.of(
                        new RoomDTO("Habitación 1", 10, 12),  // 120
                        new RoomDTO("Habitación 2", 8, 10)    // 80
                ))
                .build();

        HouseResponseDTO result = calculateService.calculate(houseDTO);
        assertEquals(160000, result.getPrice());
    }

    @Test
    @DisplayName("Verificar que la habitación más grande es la de mayores dimensiones")
    public void testBiggestRoom() {
        CalculateService calculateService = new CalculateService();

        HouseDTO houseDTO = HouseDTO.builder()
                .name("Casa de Prueba")
                .address("Calle Falsa 123")
                .rooms(List.of(
                        new RoomDTO("Habitación 1", 10, 12),  // 120
                        new RoomDTO("Habitación 2", 20, 15)   // 300 (más grande)
                ))
                .build();

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        RoomDTO biggestRoom = result.getBiggest();
        assertEquals("Habitación 2", biggestRoom.getName());
        assertEquals(20, biggestRoom.getWidth());
        assertEquals(15, biggestRoom.getLength());
        assertEquals(300, biggestRoom.getSquareFeet());
    }

    @Test
    @DisplayName("Verificar que los metros cuadrados por habitación son calculados correctamente")
    public void testRoomSquareFeetCalculation() {
        CalculateService calculateService = new CalculateService();

        HouseDTO houseDTO = HouseDTO.builder()
                .name("Casa de Prueba")
                .address("Calle Falsa 123")
                .rooms(List.of(
                        new RoomDTO("Habitación 1", 10, 12)  // 120
                ))
                .build();

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        Integer rooms = result.getSquareFeet();
        assertEquals(120, rooms);
    }

}
