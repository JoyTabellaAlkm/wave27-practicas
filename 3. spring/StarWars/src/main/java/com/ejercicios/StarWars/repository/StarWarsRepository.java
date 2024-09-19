package com.ejercicios.StarWars.repository;

import com.ejercicios.StarWars.entity.CharacterEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository {
    @Autowired
    public final ObjectMapper JSON_MAPPER = new ObjectMapper();
    List<CharacterEntity> characters = new ArrayList<>();
    public List<CharacterEntity> getCharacters(){
        try {
            characters =JSON_MAPPER.readValue(new File("src/main/resources/cStarWars.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, CharacterEntity.class));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return characters;
    }

    public List<CharacterEntity> getCharactersByName(String name){
        getCharacters();
        return characters.stream().filter(c -> c.getName().toUpperCase().contains(name.toUpperCase())).toList();
    }
}
