package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class ObtenerDiplomaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	private List<SubjectDTO> juanSubjects = new ArrayList<>(
			List.of(
					new SubjectDTO("Matemáticas", 10.0),
					new SubjectDTO("Lengua", 9.0),
					new SubjectDTO("Historia", 8.0),
					new SubjectDTO("Geografía", 7.0),
					new SubjectDTO("Física", 6.0),
					new SubjectDTO("Química", 5.0)));

	private List<SubjectDTO> pedroSubjects = new ArrayList<>(
			List.of(
					new SubjectDTO("Matemáticas", 10.0),
					new SubjectDTO("Lengua", 9.0),
					new SubjectDTO("Historia", 8.0),
					new SubjectDTO("Geografía", 7.0),
					new SubjectDTO("Física", 6.0)));

	private Set<StudentDTO> students = new HashSet<>(
			Set.of(
					new StudentDTO(1L, "Juan", "Algun mensaje", 0.0, juanSubjects ),
					new StudentDTO(2L, "Pedro", "Algun mensaje", 0.0, pedroSubjects )
			)
	);

	@Test
	public void contextLoads() {
		// Arrange
		Set<StudentDTO> expectedResult = students;

		// Act
		Set<StudentDTO> result = studentRepository.findAll();

		// Assert
		Assertions.assertTrue(result.stream()
				.map(StudentDTO::getId)
				.allMatch(
						expectedResult.stream()
								.map(StudentDTO::getId)
								.collect(Collectors.toSet())::contains));
	}

}