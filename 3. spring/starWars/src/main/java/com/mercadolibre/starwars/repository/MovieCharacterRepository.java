package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.MovieCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieCharacterRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<MovieCharacter> movieCharacters;

    public MovieCharacterRepository() {
        this.movieCharacters = loadCharacters();
    }

private List<MovieCharacter> loadCharacters() {

    try {
        return objectMapper.readValue(
                new File("src/main/resources/characters.json"),
                new TypeReference<>() {
                }
        );
    } catch (Exception e) {
        System.out.println("Error al leer el JSON" + e.getMessage());
        return null;
    }
    }

    public List<MovieCharacter> findByName(String name) {
        return movieCharacters.stream()
                .filter(mc -> mc.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
