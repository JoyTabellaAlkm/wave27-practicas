package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private final String originalJsonFilePath = "src/test/resources/users_temp.json"; // Ruta a tu archivo original
    private final String tempJsonFilePath = "src/test/resources/users.json"; // Ruta para el archivo temporal

    @BeforeEach
    public void setUp() throws IOException {
        // Copia el archivo original a un archivo temporal antes de cada prueba
        Files.copy(Path.of(originalJsonFilePath), Path.of(tempJsonFilePath));
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Eliminar el archivo temporal después de cada prueba
        Files.deleteIfExists(Path.of(tempJsonFilePath));
    }


    //Registrar estudiante
    @Test
    @DisplayName("Registrar un estudiante")
    public void registerStudentHappyPath() throws Exception {
        SubjectDTO sub1 = new SubjectDTO("Matematica", 7.0);
        SubjectDTO sub2 = new SubjectDTO("Lengua", 3.0);


        StudentDTO student = new StudentDTO();
        student.setStudentName("Fer");
        student.setSubjects(List.of(sub1, sub2));



        String payloadJson = objectMapper.writeValueAsString(student);

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


        String payloadJson = objectMapper.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                //.andDo(print()).andExpect(status().isBadRequest())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."))
                .andReturn();
    }

    //Get Student
    @DisplayName("Buscar un estudiante por un ID que existe")
    @Test
    public void getStudentByExistingId() throws Exception{

        int id = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id)
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("Matemática"))
                .andReturn();

    }

    @DisplayName("Buscar un estudiante por un ID que NO existe")
    @Test
    public void getStudentByNonExistingID() throws Exception{

        int id = 999;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id)
                .accept("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(String.format("El alumno con Id %d no se encuetra registrado.", id)));

    }

    //Modificacion de estudiante
    @DisplayName("Modificar un estudiante de manera correcta")
    @Test
    public void updateStudentOkTest() throws Exception{
        StudentDTO dto = new StudentDTO().builder()
                .studentName("Fer")
                .id(1L)
                .subject(new SubjectDTO("Matematica", 7.0))
                .subject(new SubjectDTO("Lengua", 3.0)).build();

        String dtoPayload = objectMapper.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dtoPayload))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @DisplayName("Modificar un estudiante de manera incorrecta, nombre de materia incorrecta")
    @Test
    public void updateStudentNotOkSubjectTest() throws Exception{
        StudentDTO dto = new StudentDTO().builder()
                .studentName("Fer")
                .id(1L)
                .subject(new SubjectDTO("matematica", 7.0))
                .subject(new SubjectDTO("lengua", 3.0)).build();

        String dtoPayload = objectMapper.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dtoPayload))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));
    }

    @DisplayName("Modificar un estudiante de manera incorrecta, nombre incorrecto")
    @Test
    public void updateStudentNotOkNameTest() throws Exception{
        StudentDTO dto = new StudentDTO().builder()
                .studentName("fer")
                .id(1L)
                .subject(new SubjectDTO("Matematica", 7.0))
                .subject(new SubjectDTO("Lengua", 3.0)).build();

        String dtoPayload = objectMapper.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dtoPayload))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    //Delete student

    @DisplayName("Delete un estudiante que existe")
    @Test
    public void deleteStudentOKTest() throws Exception{

        Integer id = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("Delete un estudiante que NO existe")
    @Test
    public void deleteStudentNotOKTest() throws Exception{

        Integer id = 999;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    //List all
    @Order(1)
    @DisplayName("Listar todos")
    @Test
    public void listAllTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }
}
