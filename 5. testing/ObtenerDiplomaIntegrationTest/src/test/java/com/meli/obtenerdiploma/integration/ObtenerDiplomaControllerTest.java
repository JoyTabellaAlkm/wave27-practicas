package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFileIntegration();
    }
    @DisplayName("T0001 : Analyze Score Ok")
    @Test
    void analyzeScoreOkTest() throws Exception{
        Long studentId = 1L;
        String expectedResponse = Files.readString(Paths.get("src/test/resources/expectedResponseOk.json"));
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }
    @DisplayName("T0001 : Analyze Score ID Not found")
    @Test
    void analyzeScoreIdNotFoundTest() throws Exception{
        Long studentId = 199L;
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 199 no se encuetra registrado."));
    }
}
