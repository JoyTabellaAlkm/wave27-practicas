package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    @DisplayName("Calculate Happy Path")
    public void calculate1() throws Exception{
        HouseDTO houseDTO = HouseDTO.builder()
                .name("Delfina")
                .address("Córdoba")
                .rooms(List.of(new RoomDTO("Pablo", 70, 90))).build();

        ObjectWriter writer = new ObjectMapper().writer();

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType("application/json")
                .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(payload))
                .andReturn();

    }

    @Test
    @DisplayName("Calculate Sad Path")
    public void calculate2() throws Exception{
        String houseDTO = "{}";

        ObjectWriter writer = new ObjectMapper().writer();

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType("application/json")
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(""))
                .andReturn();

    }
}
