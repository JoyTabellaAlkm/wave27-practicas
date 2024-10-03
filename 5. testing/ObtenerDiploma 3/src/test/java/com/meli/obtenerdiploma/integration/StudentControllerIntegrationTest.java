package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    @DisplayName("Registrar un estudiante")
    public void registerStudentHappyPath() throws Exception {
        StudentDTO dto = new StudentDTO().builder()
                .studentName("Fer")
                .subject(new SubjectDTO("Matematica", 7.0))
                .subject(new SubjectDTO("Lengua", 3.0)).build();

        ObjectWriter writer = new ObjectMapper().writer();

        String payloadJson = writer.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("")) //null body response
                .andReturn();
    }

    @Test
    @DisplayName("Registrar un estudiante con una materia en minuscula")
    public void registerStudentBadPath1() throws Exception {
        StudentDTO dto = new StudentDTO().builder()
                .studentName("Fer")
                .subject(new SubjectDTO("matematica", 7.0))
                .subject(new SubjectDTO("lengua", 3.0)).build();


        ObjectWriter writer = new ObjectMapper().writer();

        String payloadJson = writer.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."))
                .andReturn();
    }
}