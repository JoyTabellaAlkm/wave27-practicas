package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContainsDarthTest(){
        //Arrange
        String query = "Darth";
        CharacterDTO darthVader = new CharacterDTO("Darth Vader","none","white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO darthMaul = new CharacterDTO("Darth Maul","none","red","yellow","54BBY","male", "Dathomir","Zabrak", 175, 80);
        List<CharacterDTO> expected = List.of(darthVader, darthMaul);

        //Act
        List<CharacterDTO> obtained = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(expected.size(), obtained.size());
        Assertions.assertEquals(expected.get(0).getName(), obtained.get(0).getName());
        Assertions.assertEquals(expected.get(1).getName(), obtained.get(1).getName());
    }

    @Test
    void findAllByNameContainsLukeTest(){
        //Arrange
        String query = "Luke";
        CharacterDTO luke = new CharacterDTO( "Luke Skywalker","blond","fair","blue","19BBY", "male", "Tatooine", "Human", 172, 77);

        //Act
        List<CharacterDTO> obtained = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(1, obtained.size());
        Assertions.assertEquals(luke.getName(), obtained.get(0).getName());
    }

    @Test
    void findAllByNameContainsEmptyTest(){
        //Arrange
        String query = "xyz";

        //Act
        List<CharacterDTO> obtained = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(0, obtained.size());
    }

}
