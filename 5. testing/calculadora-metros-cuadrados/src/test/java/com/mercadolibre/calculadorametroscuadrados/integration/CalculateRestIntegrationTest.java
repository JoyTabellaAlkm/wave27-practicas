package com.mercadolibre.calculadorametroscuadrados.integration;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculateRestIntegrationTest {

    @Autowired
    CalculateRestController controller;

    @Autowired
    MockMvc mockMvc;

    private  ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    RoomDTO room1 = new RoomDTO();
    RoomDTO room2 = new RoomDTO();
    RoomDTO room3 = new RoomDTO();

    HouseDTO houseDTO = new HouseDTO();
    HouseResponseDTO houseResponseDTO;

    @BeforeEach
    public void setUp(){

        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.WRAP_EXCEPTIONS, false);


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
    public void calculateTotalSquareFootOK() throws Exception {

        String requestPayload = OBJECT_MAPPER.writeValueAsString(houseDTO);


        MvcResult result =  this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestPayload))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        HouseResponseDTO responseDTO = OBJECT_MAPPER.readValue(json, HouseResponseDTO.class);

        assertEquals(41, responseDTO.getSquareFeet());
    }


    @Test
    public void getBiggestRoomOK() throws Exception {

        String requestPayload = OBJECT_MAPPER.writeValueAsString(houseDTO);


        MvcResult result =  this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestPayload))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        HouseResponseDTO responseDTO = OBJECT_MAPPER.readValue(json, HouseResponseDTO.class);

        assertEquals(room1, responseDTO.getBiggest());
    }


}
