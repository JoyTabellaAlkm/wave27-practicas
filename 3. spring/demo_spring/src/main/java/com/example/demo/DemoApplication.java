package com.example.demo;

import com.example.demo.DTOs.FindRiskPersonsDTO;
import com.example.demo.DTOs.FindSymptomByNameDTO;
import com.example.demo.DTOs.FindSymptomsDTO;
import com.example.demo.Entities.Persona;
import com.example.demo.Entities.Sintoma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication() {
		this.personas = new ArrayList<>();
		this.sintomas = new ArrayList<>();

		var sintoma1 = new Sintoma("tos", 2);
		var sintoma2 = new Sintoma("dolor de cabeza", 3);
		sintomas.add(sintoma1);
		sintomas.add(sintoma2);

		var personaSinSintomas = new Persona("fernando", "baldrich", 23);
		var personaConSintomas1 = new Persona("juan", "perez", 63);
		personaConSintomas1.addSintoma(sintoma1);
		var personaConSintomas2 = new Persona("pedro", "gonzalez", 19);
		personaConSintomas2.addSintoma(sintoma1);
		personaConSintomas2.addSintoma(sintoma2);
		personas.add(personaSinSintomas);
		personas.add(personaConSintomas1);
		personas.add(personaConSintomas2);
	}
	List<Persona> personas;
	List<Sintoma> sintomas;

	@GetMapping("/findSymptom")
	public FindSymptomsDTO findSymptoms() {
		FindSymptomsDTO dto = new FindSymptomsDTO();
		dto.setSintomas(sintomas);
		return dto;
	}

	@GetMapping("/findSymptom/{name}")
	public ResponseEntity<FindSymptomByNameDTO > findSymptoms(@PathVariable String name) {
		FindSymptomByNameDTO dto = new FindSymptomByNameDTO();
		var sintoma = sintomas.stream().filter(s -> s.getNombre().equals(name)).findFirst().orElse(null);
		if(sintoma != null) {
			dto.setNivelGravedad(sintoma.getNivelGravedad());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("findRiskPerson")
	public FindRiskPersonsDTO findRiskPersons() {
		List<Persona> personasConSintomas = personas.stream().filter(p -> p.getEdad() > 60 && !p.getSintomas().isEmpty()).toList();
		FindRiskPersonsDTO dto = new FindRiskPersonsDTO();
		dto.setPersonas(personasConSintomas);
		return dto;
	}
}
