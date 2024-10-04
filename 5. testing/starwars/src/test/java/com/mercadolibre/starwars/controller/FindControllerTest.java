package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    CharacterDTO lukeSkywalker = new CharacterDTO();
    CharacterDTO darthVader = new CharacterDTO();

    @Mock
    FindService findService;

    @InjectMocks
    FindController controller;


    @BeforeEach
    public void setUp(){
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);
        lukeSkywalker.setHair_color("blond");
        lukeSkywalker.setSkin_color("fair");
        lukeSkywalker.setEye_color("blue");
        lukeSkywalker.setBirth_year("19BBY");
        lukeSkywalker.setGender("male");
        lukeSkywalker.setHomeworld("Tatooine");
        lukeSkywalker.setSpecies("Human");

        darthVader.setName("Darth Vader");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
    }

    @Test
    public void findExistingNameTest() throws Exception{
        //Arrange
        String query = "Luke Skywalker";
        List<CharacterDTO> resultService = List.of(lukeSkywalker);
        when(findService.find(query)).thenReturn(resultService);

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        assertEquals(1, result.size());
    }

    @Test
    public void findExistingNamesTest() throws Exception{
        //Arrange
        String query = "a";
        List<CharacterDTO> resultService = List.of(lukeSkywalker, darthVader);
        when(findService.find(query)).thenReturn(resultService);

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        assertEquals(2, result.size());
    }

    @Test
    public void findByNonExistingNamesTest() throws Exception{
        //Arrange
        String query = "Mati";
        List<CharacterDTO> resultService = List.of();
        when(findService.find(query)).thenReturn(resultService);

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

}
