package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent(){
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>());
        studentService.create(studentDTO);
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void testReadStudent(){
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>());
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO found = studentService.read(1L);
        assertEquals(studentDTO, found);
    }

    @Test
    void testReadStudentNotFound(){
        when(studentDAO.findById(1L)).thenReturn(null);
        assertNull(studentService.read(1L));
    }

    @Test
    void testDeleteStudent() {
        studentService.delete(1L);
        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    void testGetAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>()));
        students.add(new StudentDTO(2L, "Jane Doe", "message", 8.0, new ArrayList<>()));
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> result = studentService.getAll();
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
