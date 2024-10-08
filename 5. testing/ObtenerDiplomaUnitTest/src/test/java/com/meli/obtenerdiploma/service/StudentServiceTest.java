package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.Datos;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Nested
    class Create{
        @DisplayName("Test 01 : Create student ok")
        @Test
        void createOkTest() {
            when(studentDAO.save(Datos.STUDENT)).thenReturn(Datos.STUDENT);

            studentService.create(Datos.STUDENT);

            verify(studentDAO, times(1)).save(Datos.STUDENT);
        }
    }

   @Nested
   class Read{
       @DisplayName("Test 02 : Read student ok")
       @Test
       void readOkTest() {
           StudentDTO studentExpected = Datos.STUDENT;

           when(studentDAO.findById(Datos.STUDENT.getId())).thenReturn(Datos.STUDENT);
           StudentDTO studentReal = studentService.read(Datos.STUDENT.getId());
           assertEquals(studentExpected, studentReal);
       }

       @DisplayName("Test 03 : Read student Id not found")
       @Test
       void readIdNotFoundTest(){
           when(studentDAO.findById(Datos.STUDENT_NONEXISTS.getId())).thenThrow(StudentNotFoundException.class);

           assertThrows(StudentNotFoundException.class, () -> studentService.read(Datos.STUDENT_NONEXISTS.getId()));

       }
   }

   @Nested
   class Update{
       @DisplayName("Test 03 : Update student ok")
       @Test
       void updateOkTest() {
           when(studentDAO.save(Datos.STUDENT)).thenReturn(Datos.STUDENT);

           studentService.update(Datos.STUDENT);

           verify(studentDAO, times(1)).save(Datos.STUDENT);
       }
   }

   @Nested
   class Delete{
       @DisplayName("Test 04 : Delete student ok")
       @Test
       void deleteOkTest() {
           when(studentDAO.delete(Datos.STUDENT.getId())).thenReturn(true);

           studentService.delete(Datos.STUDENT.getId());

           verify(studentDAO, times(1)).delete(Datos.STUDENT.getId());
       }
   }

   @Nested
   class GetAll{
       @DisplayName("Test 05 : Get all students ok")
       @Test
       void getAllOkTest() throws Exception {
           Set<StudentDTO> studentsExpected = Datos.STUDENTS_SET;

           when(studentRepository.findAll()).thenReturn(Datos.STUDENTS_SET);

           Set<StudentDTO> studentsFound = studentService.getAll();

           assertEquals(studentsExpected, studentsFound);
       }
   }




}