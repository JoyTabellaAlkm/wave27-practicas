package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @DisplayName("Test 01 : Find all students ok")
    @Test
    void findAllTest() throws Exception {
        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();
        // Assert
        assertNotNull(actualStudents);
        assertFalse(actualStudents.isEmpty());

    }
    @DisplayName("Test 02 : Find all students File not found")
    @Test
    void findAllFileNotFoundTest() {
        studentRepository.setFilePath("./invalid/path/to/users.json");


        // Assert
        assertThrows(FileNotFoundException.class, () -> {
            studentRepository.findAll();
        });

    }

}