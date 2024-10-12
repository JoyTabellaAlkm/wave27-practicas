package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.Datos;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;
@DisplayName("TI 0001 : Find Characters Ok")
    @Test
    void findOkTest() throws Exception{
        String query = "Darth";
        List<CharacterDTO> charactersResponse = Datos.CHARACTERS_DARTH;

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String expectedJson = writer.writeValueAsString(charactersResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
    @DisplayName("TI 0001 : Find Characters Not Found")
    @Test
    void findNotFoundTest() throws Exception{
        String query = "Pepes";

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
