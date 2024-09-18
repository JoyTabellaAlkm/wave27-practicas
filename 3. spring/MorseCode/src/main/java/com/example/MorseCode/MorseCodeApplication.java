package com.example.MorseCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MorseCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorseCodeApplication.class, args);
	}
	//Para probar: http://localhost:8080/api/translate?morseCode=-- ..   -. --- -- -... . .-.   . ...   .- -. - --- -. . .-.. .-.. .-   -... .- ... .-.. ---
}
