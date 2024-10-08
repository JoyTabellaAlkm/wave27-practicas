package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("8. create student returns ok")
    public void createStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(11L,
                "Paola Argento",
                "mensaje",
                0.0,
                new ArrayList<SubjectDTO>()
        );

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    @DisplayName("9. read student returns ok")
    public void readStudent() {
        // Arrange
        StudentDTO student = new StudentDTO(11L,
                "Paola Argento",
                "mensaje",
                0.0,
                new ArrayList<SubjectDTO>()
        );

        // Act
        when(studentDAO.findById(11L)).thenReturn(student);
        StudentDTO result = studentService.read(11L);

        // Assert
        verify(studentDAO, times(1)).findById(11L);
        assertEquals(student, result);
    }

    @Test
    @DisplayName("10. read student returns null")
    public void readStudentNull() {
        when(studentDAO.findById(99L)).thenReturn(null);
        assertNull(studentService.read(99L));
    }

    @Test
    @DisplayName("11. update student returns ok")
    public void updateStudentReturnsOk() {
        // Arrange
        StudentDTO student = new StudentDTO(1L,
                "Juan Doe",
                "mensaje",
                0.0,
                new ArrayList<SubjectDTO>()
        );

        // Act
        studentService.update(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    @DisplayName("12. delete student returns ok")
    public void deleteStudentReturnsOk() {
        // Arrange
        Long id = 1L;

        // Act
        studentService.delete(id);

        // Assert
        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    @DisplayName("13. get all students returns ok")
    public void getAllStudentsReturnsOk() {
        // Arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "Juan Doe", "mensaje", 0.0, new ArrayList<SubjectDTO>()));
        students.add(new StudentDTO(2L, "Jane Doe", "mensaje", 0.0, new ArrayList<SubjectDTO>()));

        // Act
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        verify(studentRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteStudentNotFound() {
        doThrow(new RuntimeException("Student not found")).when(studentDAO).delete(1L);

        try {
            studentService.delete(1L);
        } catch (RuntimeException e) {
            assertEquals("Student not found", e.getMessage());
        }
    }
}
