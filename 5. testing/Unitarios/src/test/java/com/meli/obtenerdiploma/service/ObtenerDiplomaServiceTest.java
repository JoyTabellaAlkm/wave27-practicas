package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    @Mock
    IStudentDAO studentDAO;
    static StudentDTO stu;

    @BeforeAll
    public static void SetUp() {
        stu = new StudentDTO();
        stu.setId(2L);
        stu.setAverageScore(0.0);
        stu.setMessage("");
        SubjectDTO subjectDTO1 = new SubjectDTO("name", 0.1);
        SubjectDTO subjectDTO2 = new SubjectDTO("name", 0.1);
        SubjectDTO subjectDTO3 = new SubjectDTO("name", 0.1);
        stu.setSubjects(Arrays.asList(subjectDTO1, subjectDTO2, subjectDTO3));
        stu.setStudentName("Juan");
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void analyzeScores() {
        Long id = 2L;
        when(studentDAO.findById(2L)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        double expectedAverage = 0.10000000000000002;
        assertEquals(expectedAverage, result.getAverageScore());
    }

    @Test
    public void getGreetingMessage() {
        Long id = 2L;
        String mensaje = "El alumno Juan ha obtenido un promedio de 0,1. Puedes mejorar.";
        when(studentDAO.findById(2L)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        assertEquals(mensaje, result.getMessage());
    }

    @Test
    public void calculateAverage() {
        SubjectDTO subjectDTO1 = new SubjectDTO("name", 0.1);
        SubjectDTO subjectDTO2 = new SubjectDTO("name", 0.1);
        SubjectDTO subjectDTO3 = new SubjectDTO("name", 0.1);
        List<SubjectDTO> subjectDTOList= Arrays.asList(subjectDTO1,subjectDTO2,subjectDTO3);

        Long id = 2L;
        when(studentDAO.findById(2L)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);
        assertEquals( subjectDTOList, result.getSubjects());

    }

}
