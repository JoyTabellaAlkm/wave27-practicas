package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void findAllTest() throws Exception {
        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();
        // Assert
        assertNotNull(actualStudents);
        assertFalse(actualStudents.isEmpty());

    }
    @Test
    void findAllFileNotFoundTest() {
        studentRepository.setFilePath("./invalid/path/to/users.json");


        // Assert
        assertThrows(FileNotFoundException.class, () -> {
            studentRepository.findAll();
        });

    }

}