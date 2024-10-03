package ar.com.mercadolibre.starwars.service;

import ar.com.mercadolibre.starwars.dto.PersonajeDto;
import ar.com.mercadolibre.starwars.entity.Personaje;
import ar.com.mercadolibre.starwars.repository.PersonajesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonajesServiceImplTests {

    @Mock
    private PersonajesRepository personajesRepository;

    @InjectMocks
    private PersonajesServiceImpl personajesServiceImpl;

    @Test
    public void getFilteredReturnsFilteredPersonajes() {
        // Arrange
        String query = "Darth";
        int expectedSize = 2;
        Personaje darthVader = new Personaje();
        darthVader.setName("Darth Vader");
        Personaje darthMaul = new Personaje();
        darthMaul.setName("Darth Maul");
        Personaje lukeSkywalker = new Personaje();
        lukeSkywalker.setName("Luke Skywalker");

        when(personajesRepository.findAll()).thenReturn(List.of(darthVader, darthMaul));

        // Act
        int size = personajesServiceImpl.getFiltered(query).size();

        // Assert
        assertEquals(expectedSize, size);
    }

    @Test
    public void getFilteredMapsPersonajesToPersonajeDto() {
        // Arrange
        String query = "Darth";
        String expectedName = "Darth Vader";
        Integer expectedHeight = 202;
        Integer expectedMass = 136;
        String expectedGender = "male";
        String expectedHomeworld = "Tatooine";
        String expectedSpecies = "Human";
        Personaje darthVader = new Personaje(
                expectedName,
                expectedHeight,
                expectedMass,
                "hair color",
                "skin color",
                "eye color",
                "birth year",
                expectedGender,
                expectedHomeworld,
                expectedSpecies);

        when(personajesRepository.findAll()).thenReturn(List.of(darthVader));

        // Act
        PersonajeDto personajeDto = personajesServiceImpl.getFiltered(query).get(0);

        // Assert
        assertEquals(expectedName, personajeDto.name());
        assertEquals(expectedHeight, personajeDto.height());
        assertEquals(expectedMass, personajeDto.mass());
        assertEquals(expectedGender, personajeDto.gender());
        assertEquals(expectedHomeworld, personajeDto.homeworld());
        assertEquals(expectedSpecies, personajeDto.species());
    }
}
