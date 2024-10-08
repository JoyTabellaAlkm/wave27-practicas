package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDao;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTest() {
        // Arrange
        StudentDTO expectedStudent = createStudentDTO();

        // Act
        when(studentDao.findById(1L)).thenReturn(expectedStudent);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Mockito.verify(studentDao, atLeast(1)).findById(1L);
        assertThat(result).isEqualTo(expectedStudent);
    }

    private StudentDTO createStudentDTO() {
        return new StudentDTO(1L, "Juan", "un mensaje", 0.0, List.of(new SubjectDTO("Matematica", 10.0), new SubjectDTO("Lengua", 9.0)));
    }
}
