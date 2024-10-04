package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() throws IOException {
        studentRepository = new StudentRepository();
        createTestJsonFile();
    }

    @Test
    void findAllTest() {
        StudentDTO student = new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>());
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(student);

        Set<StudentDTO> result = studentRepository.findAll();
        assertEquals(expectedStudents, result);
    }

    private void createTestJsonFile() throws IOException {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "John Doe", "message", 9.0, new ArrayList<>()));

        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("src/main/resources/users.json");
        try (FileWriter fileWriter = new FileWriter(file)) {
            objectMapper.writeValue(fileWriter, students);
        }
    }
}
