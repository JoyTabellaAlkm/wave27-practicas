package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.Datos;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresNullIdTest() {
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(anyLong()));

    }

    @Test
    void analyzeScoresOkTest() {

        when(studentDAO.findById(Datos.STUDENT.getId())).thenReturn(Datos.STUDENT);
        StudentDTO studentFound = obtenerDiplomaService.analyzeScores(Datos.STUDENT.getId());

        assertEquals(8.0, studentFound.getAverageScore());
        assertEquals(studentFound.getMessage(),"El alumno Leandro ha obtenido un promedio de 8. Puedes mejorar.");
    }
    @Test
    void analyzeScoresPerfectScoreTest() {

        when(studentDAO.findById(Datos.STUDENT_PERFECT.getId())).thenReturn(Datos.STUDENT_PERFECT);
        StudentDTO studentFound = obtenerDiplomaService.analyzeScores(Datos.STUDENT_PERFECT.getId());

        assertEquals(10.0, studentFound.getAverageScore());
        assertEquals(studentFound.getMessage(),"El alumno Michael ha obtenido un promedio de 10. Felicitaciones!");
    }
}