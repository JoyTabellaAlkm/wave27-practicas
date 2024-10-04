package com.meli.obtenerdiploma.integracion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    @DisplayName("Id que existe")
    public void analyzeScoresIntegrationHappyPath() throws Exception {
        Integer id = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", id).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3))
                .andReturn();
    }

    @Test
    @DisplayName("Id que no existe")
    public void analyzeScoresIntegrationBadPath() throws Exception {
        Integer id = 3;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", id).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(String.format("El alumno con Id %d no se encuetra registrado.", id)))
                .andReturn();
    }
}
