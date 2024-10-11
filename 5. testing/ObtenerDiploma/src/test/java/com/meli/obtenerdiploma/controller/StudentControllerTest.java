package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentService.create(student)).thenReturn(1L);
        ResponseEntity<?> register = studentController.registerStudent(student);

        //Assert
        verify(studentService, atLeastOnce()).create(student);
        Assertions.assertEquals(HttpStatus.OK, register.getStatusCode());
        Assertions.assertNull(register.getBody());
    }

    @Test
    public void getStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentService.read(1L)).thenReturn(student);
        StudentDTO foundStudent = studentController.getStudent(1L);

        //Assert
        verify(studentService, atLeastOnce()).read(1L);
        Assertions.assertEquals(student, foundStudent);
    }

    @Test
    public void modifyStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        StudentDTO modified = new StudentDTO(1L, "Mariana", "mensaje", 8.5, List.of(
                new SubjectDTO("Ingles", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentService.update(modified)).thenReturn(1L);
        ResponseEntity<?> modify = studentController.modifyStudent(modified);

        //Assert
        verify(studentService, atLeastOnce()).update(modified);
        Assertions.assertEquals(HttpStatus.OK, modify.getStatusCode());
        Assertions.assertNull(modify.getBody());
    }

    @Test
    public void removeStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        when(studentService.delete(1L)).thenReturn(true);
        ResponseEntity<?> modify = studentController.removeStudent(1L);

        //Assert
        verify(studentService, atLeastOnce()).delete(1L);
        Assertions.assertEquals(HttpStatus.OK, modify.getStatusCode());
        Assertions.assertNull(modify.getBody());
    }

    @Test
    public void listStudentTest(){
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
        when(studentService.getAll()).thenReturn(students);
        Set<StudentDTO> foundStudents = studentController.listStudents();

        //Assert
        verify(studentService, atLeastOnce()).getAll();
        Assertions.assertIterableEquals(students, foundStudents);
    }
}
