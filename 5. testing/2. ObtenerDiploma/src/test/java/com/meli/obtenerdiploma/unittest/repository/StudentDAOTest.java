package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StudentDAOTest {
    private StudentDAO studentDAO;

    List<SubjectDTO> subjectsSuccess;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
        subjectsSuccess = Arrays.asList(
                new SubjectDTO("Matemática", 2.0),
                new SubjectDTO("Física", 6.5),
                new SubjectDTO("Química", 5.0)
        );
    }

    @Test
    @DisplayName("1. Save returns ok")
    void saveReturnsOk() {
        // Arrange
        StudentDTO student = new StudentDTO(3L,
                "Juan Carlos",
                "You have to work harder.",
                7.83,
                subjectsSuccess);

        // Act
        studentDAO.save(student);

        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("2. Delete returns ok")
    public void deleteReturnsOk() {
        // Arrange
        StudentDTO student = new StudentDTO(5L,
                "Pepe Argento",
                "¿Me estás hablando a mí?",
                7.83,
                subjectsSuccess);

        // Act
        studentDAO.save(student);
        boolean deleted = studentDAO.delete(student.getId());

        // Assert
        assertTrue(deleted);
        assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("3. Delete returns false")
    public void deleteReturnsFalse() {
        // Arrange
        StudentDTO student = new StudentDTO(99L,
                "Pepe Argento",
                "¿Me estás hablando a mí?",
                7.83,
                subjectsSuccess);
        // Act
        boolean deleted = studentDAO.delete(98L);

        // Assert
        assertFalse(deleted);
        assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("4. Exists returns true")
    public void existsReturnsTrue() {
        // Arrange
        StudentDTO student = new StudentDTO(7L,
                "Monica Argento",
                "Cafecitooooo",
                7.83,
                subjectsSuccess);

        // Act
        studentDAO.save(student);

        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("5. Exists returns false")
    public void existsReturnsFalse() {
        // Arrange
        StudentDTO student = new StudentDTO(97L,
                "Monica Argento",
                "Cafecitooooo",
                7.83,
                subjectsSuccess);

        // Act & Assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("6. FindById returns student")
    public void findByIdReturnsStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(10L,
                "Koki Argento",
                "uhhh que pelotuchoo",
                7.83,
                subjectsSuccess);

        // Act
        studentDAO.save(student);
        StudentDTO result = studentDAO.findById(student.getId());

        // Assert
        assertEquals(student, result);
    }

    @Test
    @DisplayName("7. FindById returns not found")
    public void findByIdReturnsNotFound() {
        // Arrange
        Long falseId = 100L;

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(falseId));
    }
}
