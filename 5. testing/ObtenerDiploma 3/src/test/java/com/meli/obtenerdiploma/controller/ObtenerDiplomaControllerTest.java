package com.meli.obtenerdiploma.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void analyzeScoresShouldCallServiceWithStudentId() {
        Long studentId = 2L;
        StudentDTO expectedResponse = new StudentDTO();
        when(service.analyzeScores(studentId)).thenReturn(expectedResponse);
        StudentDTO response = obtenerDiplomaController.analyzeScores(studentId);
        verify(service, times(1)).analyzeScores(studentId);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void analyzeScoresShouldReturnTheServicesResult() {
        Long studentId = 2L;
        StudentDTO expectedResponse = new StudentDTO();
        expectedResponse.setStudentName("Ana");
        when(service.analyzeScores(studentId)).thenReturn(expectedResponse);
        StudentDTO response = obtenerDiplomaController.analyzeScores(studentId);
        assertEquals(expectedResponse, response);
    }
}
