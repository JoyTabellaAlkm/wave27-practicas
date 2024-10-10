package com.meli.obtenerdiploma.Integracion.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.ObtenerDiplomaApplication;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getStudent() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void registerStudenrt() throws Exception {
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematicas", 5.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Ingles", 9.2);
        List<SubjectDTO> subjectDTO = Arrays.asList(subjectDTO1, subjectDTO2);
        StudentDTO studentDTO = new StudentDTO(1L, "Ana", "Hola", 1.00, subjectDTO);
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payLodJson = objectWriter.writeValueAsString(studentDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLodJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void modifyStudent() throws Exception {
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematicas", 5.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Ingles", 9.2);
        List<SubjectDTO> subjectDTO = Arrays.asList(subjectDTO1, subjectDTO2);
        StudentDTO studentDTO = new StudentDTO(1L, "Ana", "Hola", 1.00, subjectDTO);
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String paylodJson = objectWriter.writeValueAsString(studentDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void removeStudent () throws Exception {
        this.mockMvc
                .perform( MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(""));
    }
    @Test
    public void listStudents () throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]studentName").value("Pedro"))
                .andReturn();
    }



}
