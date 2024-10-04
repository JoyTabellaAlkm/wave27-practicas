package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@SpringBootTest
public class StudentTest {

    // siempre se mockean los repositorios
    @Mock
    private StudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    // siempre se injecta el server o el controller
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Agregar Alumno")
    public void add(){
        StudentDTO studentDTO = new StudentDTO();

        studentService.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Buscar alumno por id")
    public void findById(){
        StudentDTO studentDTO = new StudentDTO();

        studentService.read(studentDTO.getId());

        verify(studentDAO, times(1)).findById(studentDTO.getId());
    }

    @Test
    @DisplayName("Modificar los datos de un alumno")
    public void update(){
        StudentDTO studentDTO = new StudentDTO();

        studentService.update(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Eliminar a un alumno")
    public void delete(){
        StudentDTO studentDTO = new StudentDTO();

        studentService.delete(studentDTO.getId());

        verify(studentDAO, times(1)).delete(studentDTO.getId());
    }

    @Test
    @DisplayName("Listar todos los alumnos")
    public void getAll() {
        // Arrange
        StudentDTO studentDTO1 = new StudentDTO();
        StudentDTO studentDTO2 = new StudentDTO();
        Set<StudentDTO> studentDTOS = new HashSet<>();
        studentDTOS.add(studentDTO1);
        studentDTOS.add(studentDTO2);

        when(studentService.getAll()).thenReturn(studentDTOS); // es para mockear el resultado
                                                                // es decir, que muestre a los dos que agregue

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        Assertions.assertEquals(studentDTOS, result);
        verify(studentRepository, times(1)).findAll(); // verifica que el método ha sido llamado
    }



}
