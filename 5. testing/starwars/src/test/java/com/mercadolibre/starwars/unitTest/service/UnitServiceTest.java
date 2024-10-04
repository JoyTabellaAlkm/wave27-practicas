package com.mercadolibre.starwars.unitTest.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UnitServiceTest {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Find Happy Path")
    public void find(){

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        List<CharacterDTO> mockCharacters = List.of(characterDTO);
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(mockCharacters);

        List<CharacterDTO> result = findService.find("Luke");

        assertNotNull(result);
        assertEquals("Luke", result.get(0).getName());
    }

    @Test
    @DisplayName("Find Bad Path")
    public void find1(){

        when(characterRepository.findAllByNameContains("John")).thenThrow(HttpClientErrorException.NotFound.class);

        Assertions.assertThrows(HttpClientErrorException.NotFound.class, () -> {
            findService.find("John");
        });
    }
}
