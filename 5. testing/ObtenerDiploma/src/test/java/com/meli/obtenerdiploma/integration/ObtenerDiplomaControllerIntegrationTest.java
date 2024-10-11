package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.initializeUsersFile();
    }

    @Test
    public void analyzeScoresTest() throws Exception {
        Integer studentId = 1;
        mockMvc.perform(get("/analyzeScores/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(    "1"))
                .andExpect(jsonPath("$.studentName").value(    "Juan"))
                .andExpect(jsonPath("$.message").value(    "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar."))
                .andExpect(jsonPath("$.averageScore").value(    "7.333333333333333"))
        ;
    }

    @Test
    public void analyzeScoresNotFoundTest() throws Exception {
        Integer studentId = 100;
        mockMvc.perform(get("/analyzeScores/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(    "StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value(    "El alumno con Id 100 no se encuetra registrado."))
        ;
    }
}
