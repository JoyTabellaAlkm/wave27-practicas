package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFileIntegration();
    }

    @Nested
    class RegisterStudent {
        @DisplayName("T0002 : Register student Ok")
        @Test
        void registerStudentOkTest() throws Exception {
            StudentDTO studentPayload = new StudentDTO(200L, "Pepe", null, null,
                    List.of(new SubjectDTO("Ingles", 10.0)));

            ObjectWriter writer = new ObjectMapper().
                    configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer().withDefaultPrettyPrinter();
            String payloadJson = writer.writeValueAsString(studentPayload);

            mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson))
                    .andExpect(status().isOk())
                    .andExpect(content().string(""));
        }

        @DisplayName("T0002 : Register student Null name")
        @Test
        void registerStudentBadRequestTest() throws Exception {
            StudentDTO studentPayload = new StudentDTO(200L, null, null, null,
                    List.of(new SubjectDTO("Ingles", 10.0)));

            ObjectWriter writer = new ObjectMapper().
                    configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer().withDefaultPrettyPrinter();
            String payloadJson = writer.writeValueAsString(studentPayload);

            mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson))
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                    .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
        }
    }

    @Nested
    class GetStudent {

        @DisplayName("T0003 : Get Student by ID Ok")
        @Test
        void getStudentOkTest() throws Exception {
            Long idStudent = 1L;
            String expectedResponse = Files.readString(Paths.get("src/test/resources/expectedResponseOk.json"));

            mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{idStudent}", idStudent)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(expectedResponse));
        }

        @DisplayName("T0003 : Get Student by ID Not found")
        @Test
        void getStudentNotFoundTest() throws Exception {
            Long idStudent = 300L;

            mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{idStudent}", idStudent)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                    .andExpect(jsonPath("$.description").value("El alumno con Id 300 no se encuetra registrado."));
        }
    }

    @Nested
    class ModifyStudent {
        @DisplayName("T0004 : Modify student Ok")
        @Test
        void modifyStudentOkTest() throws Exception {
            StudentDTO studentPayload = new StudentDTO(2L, "Pedro", null, null,
                    List.of(new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 5.0),
                            new SubjectDTO("Química", 1.0)));

            ObjectWriter writer = new ObjectMapper().
                    configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer().withDefaultPrettyPrinter();
            String payloadJson = writer.writeValueAsString(studentPayload);

            mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson))
                    .andExpect(status().isOk())
                    .andExpect(content().string(""));

        }

        @DisplayName("T0004 : Modify student Null name")
        @Test
        void registerStudentBadRequestTest() throws Exception {
            StudentDTO studentPayload = new StudentDTO(2L, null, null, null,
                    List.of(new SubjectDTO("Matemática", 10.0),
                            new SubjectDTO("Física", 5.0),
                            new SubjectDTO("Química", 1.0)));

            ObjectWriter writer = new ObjectMapper().
                    configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer().withDefaultPrettyPrinter();
            String payloadJson = writer.writeValueAsString(studentPayload);

            mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson))
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                    .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
        }
    }

    @Nested
    class RemoveStudent {
        @DisplayName("T0005 : Remove Student Ok")
        @Test
        void removeStudentOkTest() throws Exception {
            Long idStudent = 2L;

            mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{idStudent}", idStudent)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(""));
        }
    }
    @Nested
    class ListStudents{
        @DisplayName("T0006 : List Students Ok")
        @Test
        void listStudentsOkTest() throws Exception{
            String expectedResponse = Files.readString(Paths.get("src/test/resources/users.json"));
            mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents/")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(expectedResponse));
        }
    }

}
