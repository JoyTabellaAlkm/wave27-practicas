package com.ejercicio.starwars.repository;

import com.ejercicio.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepository {

    public List<Personaje> loadFile() throws IOException {
        List<Personaje> personajes;
        File file = new File("src/main/resources/starwars.json");
        ObjectMapper objectMapper = new ObjectMapper();
        personajes = objectMapper.readValue(file, new TypeReference<>() {});

        return personajes;
    }
}
