package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServicesTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    static StudentDTO stu;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

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

    @Test
    public void create() {
        studentDAO.save(stu);
        verify(studentDAO, times(1)).save(stu);
    }

    @Test
    public void read() {
        Long id= 2L;
        when(studentDAO.findById(id)).thenReturn(stu);
        StudentDTO result =studentService.read(id);
        Assertions.assertEquals(result,stu);
        verify(studentDAO, times(1)).findById(id);
    }

    @Test
    public void update() {
        studentDAO.save(stu);
        verify(studentDAO, times(1)).save(stu);
    }

    @Test
    public void delete() {
        long id =2L;
        studentDAO.delete(id);
        verify(studentDAO,times(1)).delete(id);
    }

    @Test
    public void getAll() {
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(new StudentDTO());
        when(studentRepository.findAll()).thenReturn(studentDTOSet);
        Set<StudentDTO> result= studentService.getAll();
        Assertions.assertEquals(studentDTOSet,result);
        verify(studentRepository, times(1)).findAll();
    }
}
