package com.meli.obtenerdiploma.unitTest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO studentDTO;

    @Test
    @DisplayName("Test 01 - Controller")
    public void analyzeScoresTest(){
        //arrange
        Long studentId = 1L;
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(8.5);
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(studentDTO);
        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);
        //assert
        assertEquals("Juan", result.getStudentName());
        assertEquals(8.5, result.getAverageScore());
        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);
    }

    @Test
    public void obtenerDiplomaExceptionControllerTest(){

    }




}
