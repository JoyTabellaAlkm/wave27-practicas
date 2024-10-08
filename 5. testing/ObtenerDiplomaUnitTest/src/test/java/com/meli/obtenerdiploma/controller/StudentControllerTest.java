package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.Datos;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Nested
    class Register {
        @DisplayName("Test 01 : Register student ok")
        @Test
        void registerStudent() {

            controller.registerStudent(Datos.STUDENT);

            verify(service, atLeastOnce()).create(Datos.STUDENT);
        }
    }

    @Nested
    class Find {
        @DisplayName("Test 02 : Find student by Id ok")
        @Test
        void getStudent() {
            StudentDTO studentExpected = Datos.STUDENT;
            when(service.read(Datos.STUDENT.getId())).thenReturn(Datos.STUDENT);
            StudentDTO studentFound = controller.getStudent(Datos.STUDENT.getId());

            assertEquals(studentExpected, studentFound);
            verify(service, times(1)).read(Datos.STUDENT.getId());

        }
        @DisplayName("Test 03 : Find all students ok")
        @Test
        void listStudents() throws Exception {
            Set<StudentDTO> studentsExpected = Datos.STUDENTS_SET;

            when(service.getAll()).thenReturn(Datos.STUDENTS_SET);
            Set<StudentDTO> studentsFound = controller.listStudents();

            assertEquals(studentsExpected, studentsFound);
            verify(service, times(1)).getAll();

        }
    }

    @Nested
    @DisplayName("Test 04 : Modify student ok")
    class Modify {
        @Test
        void modifyStudent() {
            controller.modifyStudent(Datos.STUDENT);
            verify(service, times(1)).update(Datos.STUDENT);
        }
    }

    @Nested
    @DisplayName("Test 05 : Remove student ok")
    class Remove {
        @Test
        void removeStudent() {
            controller.removeStudent(Datos.STUDENT.getId());
            verify(service, times(1)).delete(Datos.STUDENT.getId());
        }
    }


}