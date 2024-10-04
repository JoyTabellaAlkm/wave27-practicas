package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Mock
    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAnalyzeScores_NullStudent() {
        when(studentDAO.findById(1L)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

    @Test
    void testAnalyzeScores_ValidStudent() {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 8.0));
        subjects.add(new SubjectDTO("Science", 9.0));
        StudentDTO student = new StudentDTO(1L, "John Doe", null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(8.5, result.getAverageScore());
        assertEquals("El alumno John Doe ha obtenido un promedio de 8.5. Puedes mejorar.", result.getMessage());
    }

    @Test
    void testAnalyzeScores_Honors() {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 10.0));
        subjects.add(new SubjectDTO("Science", 10.0));
        StudentDTO student = new StudentDTO(1L, "John Doe", null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(10.0, result.getAverageScore());
        assertEquals("El alumno John Doe ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

}
