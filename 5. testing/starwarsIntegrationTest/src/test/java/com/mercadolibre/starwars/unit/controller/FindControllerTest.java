package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.Datos;
import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @DisplayName("Test 01 : Find all by name ok")
    @Test
    void findOkTest() {
        List<CharacterDTO> expectedCharacters = Datos.CHARACTERS_DARTH;
        when(service.find("Darth")).thenReturn(Datos.CHARACTERS_DARTH);
        List<CharacterDTO> foundCharacters = controller.find("Darth");

        assertEquals(expectedCharacters,foundCharacters);
    }
    @DisplayName("Test 01 : Find all by name nothing found")
    @Test
    void findCharactersNotFoundTest() {
        List<CharacterDTO> expectedCharacters = emptyList();
        when(service.find("holaa")).thenReturn(emptyList());
        List<CharacterDTO> foundCharacters = controller.find("holaa");

        assertEquals(expectedCharacters,foundCharacters);
    }

}