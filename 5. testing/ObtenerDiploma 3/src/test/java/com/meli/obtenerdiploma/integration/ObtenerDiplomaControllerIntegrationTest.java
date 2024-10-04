package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void analyzeScoresOK() throws Exception {
        Integer id = 1;

        this.mockMvc.perform(get("/analyzeScores/{id}", id) // Pasa el id directamente
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Verifica que el estado sea 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verifica el tipo de contenido
                .andExpect(jsonPath("$.id").value(id)); // Comparación directa con el id
    }
}
