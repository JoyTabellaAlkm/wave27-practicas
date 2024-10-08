package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.Datos;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Test 01 : Find all by name ok")
    void findOkTest() {
        List<CharacterDTO> expectedCharacters = Datos.CHARACTERS_DARTH;

        when(repository.findAllByNameContains("Darth")).thenReturn(Datos.CHARACTERS_DARTH);
        List<CharacterDTO> foundCharacters = service.find("Darth");

        assertEquals(expectedCharacters, foundCharacters);

    }
    @DisplayName("Test 02 : Find all by name nothing found")
    @Test
    void findCharactersNotFoundTest() {
        List<CharacterDTO> expectedCharacters = emptyList();

        when(repository.findAllByNameContains("holaa")).thenReturn(emptyList());
        List<CharacterDTO> foundCharacters = service.find("holaa");

        assertEquals(expectedCharacters, foundCharacters);

    }
}