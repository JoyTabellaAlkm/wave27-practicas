package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class StudentDAOTest {
    @Autowired
    private StudentDAO studentDAO;

//    @BeforeEach
//    public void setUp() {
//        studentDAO = new StudentDAO();
//    }

    //Agregar un alumno
    @DisplayName("Test save student should be ok")
    @Test
    public void saveShouldBeOk() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO(2L, "Celeste", "test: saveShouldBeOk", 9.0, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Lengua", 8.0)));
        // Act
        boolean result = studentDAO.save(expectedStudent);
        // Assert
        assertTrue(result);
    }

    //Buscar un alumno por Id.
    @DisplayName("Test find by id student should be ok")
    @Test
    public void findByIdShouldBeOk() {
        // Arrange
        Long id = 1L;
        // Act
        StudentDTO result = studentDAO.findById(id);
        // Assert
        assertEquals(result.getId(), id);
    }

    //Modificar los datos de un alumno.
    @DisplayName("Test update student should be ok")
    @Test
    public void updateShouldBeOk() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO(1L, "CelesteEditado", "test: updateShouldBeOk", 9.0, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Lengua", 8.0)));
        // Act
        boolean result = studentDAO.save(expectedStudent);
        // Assert
        assertTrue(result);
    }

    //Eliminar un alumno.
    @DisplayName("Test delete student should be ok")
    @Test
    public void deleteShouldBeOk() {
        // Arrange
        Long id = 1L;
        // Act
        boolean result = studentDAO.delete(id);
        // Assert
        assertTrue(result);
    }

}
