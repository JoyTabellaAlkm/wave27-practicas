package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private  ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresHighTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO obtenido = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        Assertions.assertEquals("El alumno Maria ha obtenido un promedio de 9,5. Felicitaciones!", obtenido.getMessage());
        Assertions.assertEquals(9.5, obtenido.getAverageScore());
    }

    @Test
    public void analyzeScoresLowTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", "mensaje", 5.0, List.of(
                new SubjectDTO("Matemáticas", 3.0),
                new SubjectDTO("Ingles", 5.0)
        ));

        //Act
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO obtenido = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 4. Puedes mejorar.", obtenido.getMessage());
        Assertions.assertEquals(4.0, obtenido.getAverageScore());
    }

}
