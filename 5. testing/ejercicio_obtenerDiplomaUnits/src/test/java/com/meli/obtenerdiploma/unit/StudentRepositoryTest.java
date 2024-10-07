package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDAO studentDAO;

//    @BeforeEach
//    public void setUp() {
//        studentRepository = new StudentRepository();
//        studentDAO = new StudentDAO();
//    }

    //Listar todos los alumnos.
    @DisplayName("get all students should be ok")
    @Test
    public void getAllShouldReturnOk() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO(1L, "Celeste", "test: studentRepository", 9.0, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Lengua", 8.0)));
        studentDAO.save(expectedStudent);
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertTrue(result.contains(expectedStudent), "The student should be present in the result set.");

    }

}
