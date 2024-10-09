package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforeEach(){

    }

    @Test
    @DisplayName("Registar estudiantes de manera correcta")
    public void registerStudentTestOK() throws Exception {

        //creando el estudiante
        StudentDTO payloadDTO = new StudentDTO(3L,"Hermes", "Mensaje xd", 6.6, List.of(new SubjectDTO("Matematicas",8.0)) );

        String payloadJson = writer.writeValueAsString(payloadDTO);

        //MvcResult response =
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();

    }

    @Test
    @DisplayName("Registar estudiantes de manera invalida")
    public void registerStudentTestInvalid() throws Exception {

        //creando el estudiante
        StudentDTO payloadDTO = new StudentDTO();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        //MvcResult response =
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id no puede ser nulo."))
                .andReturn();

    }

    @Test
    @DisplayName("Obtener estudiantes de manera correcta")
    public void getStudentTest() throws Exception {

        StudentDTO studentExpected = new StudentDTO(3L, "Hermes", "Mensaje xd", 6.6, List.of(new SubjectDTO("Matematicas", 8.0)));

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        StudentDTO studentResponse = objectMapper.readValue(response.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(studentExpected, studentResponse);

    }

    @Test
    @DisplayName("Modificar estudiantes de manera correcta")
    public void modifyStudentTest() throws Exception {

        StudentDTO studentDTOPayload = new StudentDTO(3L,"Hermes", "Mensaje xd mod", 6.6, List.of(new SubjectDTO("Matematicas",8.0)) );

        String payloadJson = writer.writeValueAsString(studentDTOPayload);

        //MvcResult response =
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();

    }

    @Test
    @DisplayName("Eliminar estudiantes de manera correcta")
    public void removeStudentTest() throws Exception {

        //StudentDTO studentExpected = new StudentDTO(2L, "Hermes", "Mensaje xd", 6.6, List.of(new SubjectDTO("Matematicas", 8.0)));

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        Assertions.assertNull(response.getResponse().getContentType());

    }

    @Test
    @DisplayName("Listar estudiantes de manera correcta")
    public void listStudentsTest() throws Exception {

        Set<StudentDTO> studentsExpected = Set.of(
                new StudentDTO(3L, "Hermes", "Mensaje xd mod", 6.6, List.of(new SubjectDTO("Matematicas", 8.0))),
                new StudentDTO(1L, "Hermes", "Mensaje xd", 6.6, List.of(new SubjectDTO("Matematicas", 8.0)))
        );

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Set<StudentDTO> studentSetResponse = objectMapper.readValue(response.getResponse().getContentAsString(), new TypeReference<Set<StudentDTO>>() {});

        Assertions.assertEquals(studentsExpected, studentSetResponse);

    }
}
