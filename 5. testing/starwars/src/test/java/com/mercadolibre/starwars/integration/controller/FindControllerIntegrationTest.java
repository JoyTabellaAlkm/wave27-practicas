package com.mercadolibre.starwars.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void findDarthTest() throws Exception{
        String query = "Darth";
        CharacterDTO darthVader = new CharacterDTO("Darth Vader","none","white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO darthMaul = new CharacterDTO("Darth Maul","none","red","yellow","54BBY","male", "Dathomir","Zabrak", 175, 80);
        List<CharacterDTO> expected = List.of(darthVader, darthMaul);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedJson = writer.writeValueAsString(expected);

        mockMvc.perform(get("/{query}", query)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson))
        ;
    }

    @Test
    void findLukeTest() throws Exception{
        String query = "Luke";
        CharacterDTO luke = new CharacterDTO( "Luke Skywalker","blond","fair","blue","19BBY", "male", "Tatooine", "Human", 172, 77);
        List<CharacterDTO> expected = List.of(luke);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedJson = writer.writeValueAsString(expected);

        mockMvc.perform(get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson))
        ;
    }

    @Test
    void findEmptyTest() throws Exception{
        String query = "xyz";

        mockMvc.perform(get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"))
        ;
    }
}
