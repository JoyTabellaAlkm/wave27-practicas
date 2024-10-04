package com.mercadolibre.starwars;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findAllCharactersTest() {
        String queryName = "Darth";

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");

        Mockito.when(findService.find(Mockito.anyString())).thenReturn(new ArrayList<>(List.of(darthVader)));

        List<CharacterDTO> characters = findController.find(queryName);

        Assertions.assertTrue(characters.stream()
                .allMatch(characterDTO -> characterDTO.getName().startsWith(queryName)));
    }
}
