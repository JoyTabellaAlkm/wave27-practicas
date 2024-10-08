package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.Datos;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("Test 01 : Analyze Score ok")
    void analyzeScoresOkTest() {

        controller.analyzeScores(Datos.STUDENT.getId());
        verify(service, times(1)).analyzeScores(Datos.STUDENT.getId());

    }
}