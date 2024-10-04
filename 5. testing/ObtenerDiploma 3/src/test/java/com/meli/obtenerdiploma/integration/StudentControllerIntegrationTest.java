package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void registerStudentIntegrationTest() throws Exception{
        SubjectDTO subject1 = new SubjectDTO();
        subject1.setName("Matemáticas");
        subject1.setScore(85.0);

        SubjectDTO subject2 = new SubjectDTO();
        subject2.setName("Lengua Española");
        subject2.setScore(90.5);

        // Agregar las materias a una lista
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        // Crear el objeto StudentDTO
        StudentDTO student = new StudentDTO();
        student.setStudentName("Carlos"); // Debe empezar con mayúscula
        student.setSubjects(subjects);



        String studentPayload = objectMapper.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType("application/json")
                        .content(studentPayload))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
