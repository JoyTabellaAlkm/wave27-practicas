package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findDarthTest(){
        //Arrange
        String query = "Darth";
        CharacterDTO darthVader = new CharacterDTO("Darth Vader","none","white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO darthMaul = new CharacterDTO("Darth Maul","none","red","yellow","54BBY","male", "Dathomir","Zabrak", 175, 80);
        List<CharacterDTO> expected = List.of(darthVader, darthMaul);

        //Act
        when(findService.find(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findController.find(query);

        //Assert
        Assertions.assertEquals(2, obtained.size());
        Assertions.assertEquals(expected.get(0).getName(), obtained.get(0).getName());
        Assertions.assertEquals(expected.get(1).getName(), obtained.get(1).getName());
    }


    @Test
    void findLukeTest(){
        //Arrange
        String query = "Luke";
        CharacterDTO luke = new CharacterDTO( "Luke Skywalker","blond","fair","blue","19BBY", "male", "Tatooine", "Human", 172, 77);
        List<CharacterDTO> expected = List.of(luke);

        //Act
        when(findService.find(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findController.find(query);

        //Assert
        Assertions.assertEquals(1, obtained.size());
        Assertions.assertEquals(luke.getName(), obtained.get(0).getName());
    }

    @Test
    void findEmptyTest(){
        //Arrange
        String query = "xyz";

        //Act
        when(findService.find(query)).thenReturn(List.of());
        List<CharacterDTO> obtained = findController.find(query);

        //Assert
        Assertions.assertEquals(0, obtained.size());
    }
}
