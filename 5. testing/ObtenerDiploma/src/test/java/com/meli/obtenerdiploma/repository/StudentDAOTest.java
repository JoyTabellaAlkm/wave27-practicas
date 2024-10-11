package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.initializeUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void saveNewStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        Long save = studentDAO.save(student);

        //Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student.getId(), save);
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void saveExistingStudentTest(){
        //Equivale a modificar estudiante

        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        Long existing = studentDAO.save(student);

        //Act
        student.setStudentName("Mariana");
        student.setAverageScore(10.0);
        student.setId(3L);
        Long save = studentDAO.save(student);

        //Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(existing, save);
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void deleteExistingStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        studentDAO.save(student);

        //Act
        boolean deleteStudent = studentDAO.delete(student.getId());

        //Assert
        Assertions.assertTrue(deleteStudent);
        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    public void deleteNonExistingStudentTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        boolean deleteStudent = studentDAO.delete(student.getId());

        //Assert
        Assertions.assertFalse(deleteStudent);
        Assertions.assertFalse(studentDAO.exists(student));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(student.getId()));
    }

    @Test
    public void existTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        studentDAO.save(student);

        //Act
        boolean exists = studentDAO.exists(student);

        //Assert
        Assertions.assertTrue(exists);
    }

    @Test
    public void existFalseTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act
        boolean exists = studentDAO.exists(student);

        //Assert
        Assertions.assertFalse(exists);
    }

    @Test
    public void findByIdTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));
        studentDAO.save(student);

        //Act
        StudentDTO foundStudent = studentDAO.findById(student.getId());

        //Assert
        Assertions.assertEquals(foundStudent, student);
    }

    @Test
    public void findByIdFailedTest(){
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Maria", "mensaje", 8.5, List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Ingles", 9.0)
        ));

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(student.getId()));
    }
}
