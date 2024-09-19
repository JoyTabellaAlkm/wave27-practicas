package com.ejercicios.StarWars;

import com.ejercicios.StarWars.repository.StarWarsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
		StarWarsRepository warsRepository = new StarWarsRepository();
		warsRepository.getCharacters();
	}

}
