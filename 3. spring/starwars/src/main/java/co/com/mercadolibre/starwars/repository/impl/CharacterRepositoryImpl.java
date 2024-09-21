package co.com.mercadolibre.starwars.repository.impl;

import co.com.mercadolibre.starwars.dto.response.CharacterDTO;
import co.com.mercadolibre.starwars.entity.Character;
import co.com.mercadolibre.starwars.exception.UnableToUploadFileException;
import co.com.mercadolibre.starwars.repository.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository @Getter
public class CharacterRepositoryImpl implements ICharacterRepository {
    private List<Character> characterList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Long nextId = 1L;

    public CharacterRepositoryImpl() {
        this.characterList = loadFile();
    }

    public List<Character> loadFile() {
        try {
            List<Character> loadedCharacters = objectMapper.readValue(
                    new File("src/main/resources/3. c. starwars.json"),
                    new TypeReference<List<Character>>() {
                    }
            );
            loadedCharacters.forEach(character -> character.setId(nextId++));
            characterList.addAll(loadedCharacters);
            return characterList;
        } catch (Exception e) {
            throw new UnableToUploadFileException("No se pudo leer la información del archivo JSON");
        }
    }
}
