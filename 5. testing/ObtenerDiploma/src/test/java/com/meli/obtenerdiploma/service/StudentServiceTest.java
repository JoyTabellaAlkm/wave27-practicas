package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private  StudentService studentService;

    @Test
    public void createStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentDAO.save(student)).thenReturn(1L);
        Long createdId = studentService.create(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
        Assertions.assertEquals(1L, createdId);
    }

    @Test
    public void readStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO found = studentService.read(1L);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(1L);
        Assertions.assertEquals(student, found);
    }

    @Test
    public void updateStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentDAO.save(student)).thenReturn(1L);
        Long createdId = studentService.update(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
        Assertions.assertEquals(1L, createdId);
    }

    @Test
    public void deleteStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentDAO.delete(1L)).thenReturn(true);
        Boolean deleted = studentService.delete(1L);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(1L);
        Assertions.assertTrue(deleted);
    }

    @Test
    public void getAllStudentTest(){
        //Arrange
        StudentDTO student1 = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        StudentDTO student2 = new StudentDTO(2L, "Juan", "mensaje", 3.0, List.of(
                new SubjectDTO("Sociales", 7.4),
                new SubjectDTO("Biologia", 7.2)
        ));
        StudentDTO student3 = new StudentDTO(3L, "Nicolas", "mensaje", 6.8, List.of(
                new SubjectDTO("Matemáticas", 6.7),
                new SubjectDTO("Biologia", 8.8)
        ));
        Set<StudentDTO> students = Set.of(student1, student2, student3);

        //Act
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> foundedStudents = studentService.getAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
        Assertions.assertEquals(students, foundedStudents);
    }

}
