package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;


public class StudentRepositoryTest {

    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.initializeUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void findAllTest(){
        // arrange
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
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        // act
        Set<StudentDTO> foundSet = studentRepository.findAll();

        // assert
        Assertions.assertEquals(students.size(), foundSet.size());
        //Assertions.assertIterableEquals(students, foundSet);
        //Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }
}
