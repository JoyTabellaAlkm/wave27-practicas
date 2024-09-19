package ar.com.mercadolibre.dto.starWars.repository;

import ar.com.mercadolibre.dto.starWars.model.StarWarsCharacter;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StarWarsRepository {
    private final List<StarWarsCharacter> characters;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public StarWarsRepository() {
        this.characters = loadCharacters();
    }

    public List<StarWarsCharacter> loadCharacters(){
        // Deserializa el JSON de un archivo en una lista de StarWarsCharacter
        try {
            return objectMapper.readValue(
                    new File("src/main/resources/starwars.json"),
                    new TypeReference<>() {
                    }
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<StarWarsCharacter> getCharacters() {
        return characters;
    }

}
