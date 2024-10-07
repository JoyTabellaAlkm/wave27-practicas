package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerTest {
    @Autowired
    MockMvc mockMvc;

    private final List<RoomDTO> rooms = new ArrayList<>();
    private HouseDTO houseDto;

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
    public void calculateControllerTest() throws Exception {
        createHouseDto();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonHouseDto = objectMapper.writer().writeValueAsString(houseDto);
        String jsonExpectedResult = objectMapper.writeValueAsString(createExpectedResult());

        MvcResult result = this.mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHouseDto))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(jsonExpectedResult, result.getResponse().getContentAsString());
    }

    @Test
    public void calculateControllerTestReturnsFail() throws Exception {
        createHouseDto();
        HouseResponseDTO expectedResult = createExpectedResult();
        expectedResult.setSquareFeet(35);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonHouseDto = objectMapper.writer().writeValueAsString(houseDto);
        String jsonExpectedResult = objectMapper.writeValueAsString(expectedResult);

        MvcResult result = this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonHouseDto))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertNotEquals(jsonExpectedResult, result.getResponse().getContentAsString());
    }

    private HouseResponseDTO createExpectedResult() {
        HouseResponseDTO expectedResult = new HouseResponseDTO(
                38,
                30400,
                rooms.get(0)
        );

        expectedResult.setAddress("Transilvania 123");
        expectedResult.setName("Murder House");
        expectedResult.setRooms(rooms);

        return expectedResult;
    }


}
