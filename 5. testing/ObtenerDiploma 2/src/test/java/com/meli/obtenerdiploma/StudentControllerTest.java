package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentControllerTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Calcular promedio Nulos")
    public void calcularPromedioException(){
        // Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        // Act
        when(obtenerDiplomaService.analyzeScores((long) 1)).thenReturn(null);

        // Assert
        Assertions.assertThrows(RuntimeException.class, () -> obtenerDiplomaService.analyzeScores((long) 1));
    }

    @Test
    @DisplayName("Calcular promedio División por cero")
    public void calcularPromedioDivCero() {
        // Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        when(obtenerDiplomaService.calculateAverage(subjectDTOList))
                .thenThrow(new ArithmeticException("División por cero"));

        // Act y Assert
        Assertions.assertThrows(ArithmeticException.class, () -> {
            obtenerDiplomaService.calculateAverage(subjectDTOList);
        });
    }

    @Test
    @DisplayName("Calcular promedio")
    public void calcularPromedio() {
        // Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemáticas", 8.0));
        subjectDTOList.add(new SubjectDTO("Ciencias", 7.0));
        subjectDTOList.add(new SubjectDTO("Ciencias en Computación", 9.5));

        StudentDTO studentDTO = new StudentDTO((long) 7, "Delfina", "Mensaje", 8.16, subjectDTOList);

        // Act
        StudentDTO promedio = obtenerDiplomaService.analyzeScores((long) 1); // Me devuelve null el promedio por lo cual nunca va a pasar el test

        // Assert
        Assertions.assertEquals(8.16, promedio.getAverageScore());
    }
}
