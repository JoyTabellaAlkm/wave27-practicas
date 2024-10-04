package com.mercadolibre.starwars.unitTest.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnitControllerTest {

    // Un test de Controller unitarios no tiene tanto sentido como el test integrador debido a que
    // testeamos 3 cosas, la url, que ingrese un json y que el contenido que mando sea json también

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController controller;

    @Test
    @DisplayName("Find Happy Path")
    public void find(){

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        List<CharacterDTO> mockCharacters = List.of(characterDTO);
        when(findService.find("Luke")).thenReturn(mockCharacters);

        List<CharacterDTO> result = controller.find("Luke");

        assertNotNull(result);
        assertEquals("Luke", result.get(0).getName());
    }

    @Test
    @DisplayName("Find Bad Path")
    public void find1(){

        when(findService.find("John")).thenThrow(HttpClientErrorException.NotFound.class);

        Assertions.assertThrows(HttpClientErrorException.NotFound.class, () -> {
            controller.find("John");
        });
    }
    

}
