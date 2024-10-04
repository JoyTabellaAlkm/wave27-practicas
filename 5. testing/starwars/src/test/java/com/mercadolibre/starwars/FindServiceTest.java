package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    public void setup(){
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");

        Mockito.when(characterRepository.findAllByNameContains("Darth"))
                .thenReturn(List.of(darthVader));
    }

    @Test
    public void findCharacter(){
        String queryName = "Darth";

        List<CharacterDTO> characters = findService.find(queryName);

        Mockito.verify(characterRepository,Mockito.times(1))
                .findAllByNameContains(queryName);

        Assertions.assertTrue(characters.stream()
                .allMatch(characterDTO -> characterDTO.getName().startsWith(queryName)));
    }

}
