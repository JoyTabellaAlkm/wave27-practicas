package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    StudentDTO student;

    @Autowired
    private MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    public static void setupOnce() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setup() {
        SubjectDTO subject = new SubjectDTO("Math", 10.0);
        student = new StudentDTO(3L, "John Doe", null, 10.0, List.of(subject));
    }

    @Test
    @DisplayName("registerStudent returns 200 OK when the request is valid")
    public void registerStudentReturns200OKWhenTheRequestIsValid() throws Exception{
        // Arrange
        String requestBody = writer.writeValueAsString(student);

        // Act
        // Assert
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("registerStudent returns 400 Bad Request when the request is invalid")
    public void registerStudentReturns400BadRequestWhenTheRequestIsInvalid() throws Exception{
        // Arrange
        student.setStudentName(null);
        String requestBody = writer.writeValueAsString(student);

        // Act
        // Assert
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @DisplayName("getStudent returns 200 OK when the student is found.")
    public void getStudentReturns200OK() throws Exception {
        // Arrange
        String requestBody = writer.writeValueAsString(student);

        // Act
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        // Assert
        this.mockMvc.perform(get("/student/getStudent/{studentId}", student.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(student.getAverageScore()))
                .andExpect(jsonPath("$.subjects[0].name").value(student.getSubjects().get(0).getName()))
                .andExpect(jsonPath("$.subjects[0].score").value(student.getSubjects().get(0).getScore()));
    }

    @Test
    @DisplayName("getStudent returns 404 when the student is not found.")
    public void getStudentReturnsNotFound() throws Exception {
        // Act
        // Assert
        this.mockMvc.perform(get("/student/getStudent/{studentId}", 0))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 0 no se encuetra registrado."));
    }

    @Test
    @DisplayName("modifyStudent returns 200 OK when the request is valid")
    public void modifyStudentReturns200OKWhenTheRequestIsValid() throws Exception{
        // Arrange
        String requestBody = writer.writeValueAsString(student);

        // Act
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        // Assert
        student.setStudentName("Jane Doe");
        requestBody = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("modifyStudent returns 400 Bad Request when the request is invalid")
    public void modifyStudentReturns400BadRequestWhenTheRequestIsInvalid() throws Exception{
        // Arrange
        String requestBody = writer.writeValueAsString(student);

        // Act
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        // Assert
        student.setStudentName(null);
        requestBody = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @DisplayName("removeStudent returns 200 OK when the student is found.")
    public void removeStudentReturns200OKWhenTheStudentIsFound() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", student.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("removeStudent returns 404 Not Found when the student is not found.")
    @Disabled
    public void removeStudentReturns404NotFoundWhenTheStudentIsNotFound() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", 0))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value(""));
    }

    @Test
    @DisplayName("listStudents returns 200 OK when there are students.")
    public void listStudentsReturns200OKWhenThereAreStudents() throws Exception {
        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].studentName").value("John Doe"))
                .andExpect(jsonPath("$[0].averageScore").value(10.0))
                .andExpect(jsonPath("$[0].subjects[0].name").value("Math"))
                .andExpect(jsonPath("$[0].subjects[0].score").value(10.0));
    }
}
