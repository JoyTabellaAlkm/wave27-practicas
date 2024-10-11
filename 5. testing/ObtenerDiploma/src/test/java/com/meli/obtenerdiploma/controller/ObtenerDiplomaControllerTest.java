package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresHighTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        StudentDTO expectedStudent = new StudentDTO(1L, "Maria",
                "El alumno Maria ha obtenido un promedio de 9,5. Felicitaciones!", 9.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(expectedStudent);
        StudentDTO obtainedStudent = obtenerDiplomaController.analyzeScores(1L);

        //Assert
        Assertions.assertEquals(expectedStudent, obtainedStudent);
    }
}
