package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudenDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    void testSaveStudent(){
        StudentDTO student = new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>());
        studentDAO.save(student);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    void findById(){
        StudentDTO student = new StudentDTO(2L, "John Doe", "message", 9.0, new ArrayList<>());
        studentDAO.setStudents(Set.of(student));
        StudentDTO found = studentDAO.findById(2L);
        assertEquals(student, found);
    }

    @Test
    void testFindByIdNotFound() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(2L));
    }

    @Test
    void testDeleteStudent() {
        StudentDTO student = new StudentDTO(2L, "John Doe", "message", 9.0, new ArrayList<>());
        studentDAO.setStudents(Set.of(student));
        boolean deleted = studentDAO.delete(2L);
        assertTrue(deleted);
        assertFalse(studentDAO.exists(student));
    }

    @Test
    void testDeleteStudentNotFound() {
        boolean deleted = studentDAO.delete(2L);
        assertFalse(deleted);
    }

    @Test
    void testListAllStudents() {
        StudentDTO student2 = new StudentDTO(2L, "Jane Doe", "message", 8.0, new ArrayList<>());
        studentDAO.setStudents(Set.of(student2));
        assertEquals(2, studentDAO.getAllStudents().size());
    }
}
