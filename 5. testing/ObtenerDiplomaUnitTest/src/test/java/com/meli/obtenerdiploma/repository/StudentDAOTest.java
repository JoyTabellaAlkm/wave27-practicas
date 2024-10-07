package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.Datos;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {


    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Nested
    class Save {
        @DisplayName("Test 01 : Save student that already exists OK")
        @Test
        void saveStudentAlreadyExistsTest() {
            //arrange
            Long idStudentExpected = Datos.STUDENT.getId();
            String nameStudentExpected = Datos.STUDENT.getStudentName();
            List<SubjectDTO> subjectsExpected = Datos.STUDENT.getSubjects();
            //act
            StudentDTO studentReal = studentDAO.save(Datos.STUDENT);

            //assert
            assertAll(
                    () -> assertEquals(idStudentExpected, studentReal.getId()),
                    () -> assertEquals(nameStudentExpected, studentReal.getStudentName()),
                    () -> assertEquals(subjectsExpected, studentReal.getSubjects())
            );

        }

        @DisplayName("Test 02 : Save new student OK")
        @Test
        void saveNewStudentTest() {
            //arrange
            String nameStudentExpected = Datos.STUDENT_ID_NULL.getStudentName();
            List<SubjectDTO> subjectsExpected = Datos.STUDENT_ID_NULL.getSubjects();
            //act
            StudentDTO studentReal = studentDAO.save(Datos.STUDENT_ID_NULL);

            //assert
            assertAll(
                    () -> assertNotNull(studentReal.getId()),
                    () -> assertEquals(nameStudentExpected, studentReal.getStudentName()),
                    () -> assertEquals(subjectsExpected, studentReal.getSubjects())
            );

        }
    }

    @Nested
    class FindById {
        @DisplayName("Test 03 : Find student by id Ok")
        @Test
        void findByIdOkTest() {
            StudentDTO studentExpected = Datos.STUDENT;

            StudentDTO studentFound = studentDAO.findById(Datos.STUDENT.getId());

            assertEquals(studentExpected, studentFound);
        }

        @DisplayName("Test 04 : Find student by id Null Exception")
        @Test
        void findByIdNullTest() {
            Long idNullStudent = Datos.STUDENT_ID_NULL.getId();

            assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(Datos.STUDENT_ID_NULL.getId()));
        }
    }

    @Nested
    class Exists {
        @DisplayName("Test 05 : Exists student Ok")
        @Test
        void existsOkTest() {

            boolean exists = studentDAO.exists(Datos.STUDENT);

            assertTrue(exists);
        }

        @DisplayName("Test 05 : No exists student ")
        @Test
        void existsStudentNonExistsTest() {

            boolean exists = studentDAO.exists(Datos.STUDENT_NONEXISTS);

            assertFalse(exists);
        }
    }

    @Nested
    class Delete {
        @DisplayName("Test 07 : Delete student ok")
        @Test
        void deleteOkTest() {
            StudentDTO studentExpected = Datos.STUDENT_DELETE;
            studentDAO.setStudents(Set.of(Datos.STUDENT_DELETE));

            boolean delete = studentDAO.delete(studentExpected.getId());

            assertTrue(delete);
        }

        @DisplayName("Test 08 : Delete non exists student")
        @Test
        void deleteNotFoundTest() {
            StudentDTO student = Datos.STUDENT_NONEXISTS;
            boolean delete = studentDAO.delete(student.getId());
            assertFalse(delete);
        }
    }


}