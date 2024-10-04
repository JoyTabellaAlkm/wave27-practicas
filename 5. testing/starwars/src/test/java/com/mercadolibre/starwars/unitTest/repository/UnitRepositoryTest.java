package com.mercadolibre.starwars.unitTest.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnitRepositoryTest {
    @Mock
    private CharacterRepositoryImpl characterRepository;

    @Test
    @DisplayName("Find Happy Path")
    public void find(){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        List<CharacterDTO> mockCharacters = List.of(characterDTO);
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(mockCharacters);

        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        assertNotNull(result);
        assertEquals("Luke", result.get(0).getName());
    }

    @Test
    @DisplayName("Find Bad Path")
    public void find1(){

        when(characterRepository.findAllByNameContains("John")).thenThrow(HttpClientErrorException.NotFound.class);

        Assertions.assertThrows(HttpClientErrorException.NotFound.class, () -> {
            characterRepository.findAllByNameContains("John");
        });
    }

}
