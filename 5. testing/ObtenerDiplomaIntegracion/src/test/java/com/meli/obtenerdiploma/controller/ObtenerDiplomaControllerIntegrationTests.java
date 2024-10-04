package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    String expectedContentType = "application/json";

    @Test
    @DisplayName("analyzeScores returns 200 and the correct id when the student is found.")
    public void analyzeScoresReturnsOk() throws Exception {
        // Arrange
        int expectedId = 1;

        // Act
        // Assert
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(expectedContentType))
                .andExpect(jsonPath("$.id").value(expectedId));
    }

    @Test
    @DisplayName("analyzeScores returns 404 when the student is not found.")
    public void analizeScoresReturnsNotFound() throws Exception {
        // Act
        // Assert
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 0))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(expectedContentType))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 0 no se encuetra registrado."));
    }

}
