package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ObtenerDiplomaServiceTests {
    ObtenerDiplomaService sut = new ObtenerDiplomaService();

    static StudentDTO averageNineFiftyJohnDoe;

    @BeforeAll
    public static void setUp() {
        averageNineFiftyJohnDoe = new StudentDTO();
        averageNineFiftyJohnDoe.setStudentName("John Doe");
        SubjectDTO subject1 = new SubjectDTO();
        subject1.setScore(10.0);
        SubjectDTO subject2 = new SubjectDTO();
        subject2.setScore(9.0);
        SubjectDTO subject3 = new SubjectDTO();
        subject3.setScore(9.5);
        averageNineFiftyJohnDoe.setSubjects(List.of(subject1, subject2, subject3));
    }

    @Test
    public void analyzeScoresCalculatesAverage() {
        // Arrange
        double expectedAverage = 9.5;

        // Act
        StudentDTO result = sut.analyzeScores(averageNineFiftyJohnDoe);

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
    }

    @Test
    public void analyzeScoresCalculatesMessageForAboveAverageStudent() {
        // Arrange
        String expectedMessage = "El alumno John Doe ha obtenido un promedio de 9.5. Felicitaciones!";

        // Act
        StudentDTO result = sut.analyzeScores(averageNineFiftyJohnDoe);

        // Assert
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    public void analyzeScoresCalculatesMessageForBelowAverageStudent() {
        // Arrange
        StudentDTO averageFiveJohnDoe = new StudentDTO();
        averageFiveJohnDoe.setStudentName("John Doe");
        SubjectDTO subject1 = new SubjectDTO();
        subject1.setScore(5.0);
        averageFiveJohnDoe.setSubjects(List.of(subject1));
        String expectedMessage = "El alumno John Doe ha obtenido un promedio de 5. Puedes mejorar.";

        // Act
        StudentDTO result = sut.analyzeScores(averageFiveJohnDoe);

        // Assert
        assertEquals(expectedMessage, result.getMessage());
    }
}
