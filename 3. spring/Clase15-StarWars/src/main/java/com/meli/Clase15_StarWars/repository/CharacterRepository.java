package com.meli.Clase15_StarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.Clase15_StarWars.entity.StarWarsCharacter;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
@Getter
public class CharacterRepository {

    private final List<StarWarsCharacter> characters;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CharacterRepository(List<StarWarsCharacter> characters){
        this.characters = loadFile();
    }

    public List<StarWarsCharacter> loadFile() {

        try {
            return objectMapper.readValue(
                    new File("src/main/resources/starwars.json"),
                    new TypeReference<List<StarWarsCharacter>>() {
                    }
            );
        }catch (Exception e){
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
