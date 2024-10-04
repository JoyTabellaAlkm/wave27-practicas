package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTests {

    @Autowired
    CharacterRepository characterRepository;

    @Test
    public void findAllCharactersTest() {
        String queryName = "Darth";

        List<CharacterDTO> characters = characterRepository.findAllByNameContains(queryName);

        Assertions.assertTrue(characters.stream()
                .allMatch(characterDTO -> characterDTO.getName().startsWith(queryName)));
    }
}
