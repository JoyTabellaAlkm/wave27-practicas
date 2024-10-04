package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController sut;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = standaloneSetup(sut)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
                .build();
    }

    @Test
    public void analyzeScoresShouldCallServiceWithStudent() {
        // Arrange
        int expectedCalls = 1;
        StudentDTO requestBody = new StudentDTO();

        // Act
        sut.analyzeScores(requestBody);

        // Assert
        verify(service, times(expectedCalls)).analyzeScores(requestBody);
    }

    @Test
    public void analyzeScoresShouldReturnTheServicesResult() {
        // Arrange
        StudentDTO requestBody = new StudentDTO();
        StudentDTO expectedResponse = new StudentDTO();
        expectedResponse.setStudentName("John Doe");

        when(service.analyzeScores(requestBody)).thenReturn(expectedResponse);

        // Act
        StudentDTO response = sut.analyzeScores(requestBody);

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    public void analyzeScoresShouldReturn400WhenStudentIsInvalid() throws Exception {
        // Arrange
        StudentDTO requestBody = new StudentDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(requestBody);

        // Act
        MvcResult mvcResult = mockMvc.perform(post("/analyzeScores")
                    .contentType("application/json")
                    .content(payloadJson))
                .andDo(print())
                .andReturn();

        Assertions.assertEquals(400, mvcResult.getResponse().getStatus());
    }
}
