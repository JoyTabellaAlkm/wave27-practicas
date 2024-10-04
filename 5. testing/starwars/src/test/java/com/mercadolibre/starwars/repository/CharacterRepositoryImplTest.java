package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CharacterRepositoryImplTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    public void findAllByNameExist() throws Exception{
        //Arrange
        String character = "Luke Skywalker";

        //Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(character);

        //Assert
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }

    @Test
    public void findAllByNamesExist() throws Exception{
        //Arrange
        String character = "Darth";

        //Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(character);

        //Assert
        assertEquals(2, result.size());
    }

    @Test
    public void findAllByNonExistingName() throws Exception{
        //Arrange
        String character = "Mati";

        //Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(character);

        //Assert
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

}
