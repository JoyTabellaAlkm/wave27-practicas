package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController sut;

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
}
