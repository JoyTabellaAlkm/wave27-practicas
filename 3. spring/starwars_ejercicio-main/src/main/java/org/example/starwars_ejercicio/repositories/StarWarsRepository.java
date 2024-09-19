package org.example.starwars_ejercicio.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars_ejercicio.entities.Personaje;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository {
    private List<Personaje> personajes;

    public StarWarsRepository() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            personajes = objectMapper.readValue(new File("src/main/resources/personajes.json"), new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> personajesReturn = personajes.stream().filter(p-> p.getName().toLowerCase().contains(name.toLowerCase())).toList();
        return personajesReturn;
    }
}
