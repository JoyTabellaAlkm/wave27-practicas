package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.Datos;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @DisplayName("Test 01 : Find all by name ok")
    @Test
    void findAllByNameContainsOkTest() {
       List<CharacterDTO> expectedCharacters = Datos.CHARACTERS_DARTH;

       List<CharacterDTO> foundCharacters = repository.findAllByNameContains("Darth");

       assertEquals(expectedCharacters,foundCharacters);

    }

    @DisplayName("Test 02 : Find all by name nothing found")
    @Test
    void findAllByNameContainsNothingFoundTest() {
        List<CharacterDTO> expectedCharacters = emptyList();

        List<CharacterDTO> foundCharacters = repository.findAllByNameContains("holaa");

        assertEquals(expectedCharacters,foundCharacters);

    }
}