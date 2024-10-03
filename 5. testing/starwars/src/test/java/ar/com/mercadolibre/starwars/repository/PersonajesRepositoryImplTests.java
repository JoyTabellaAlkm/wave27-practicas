package ar.com.mercadolibre.starwars.repository;

import ar.com.mercadolibre.starwars.entity.Personaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonajesRepositoryImplTests {
    private PersonajesRepositoryImpl personajesRepositoryImpl;

    @BeforeEach
    public void beforeEach() {
        personajesRepositoryImpl = new PersonajesRepositoryImpl();
    }

    @Test
    public void getAllReturnsAllPersonajes() {
        // Arrange
        int expectedSize = 87;

        // Act
        int size = personajesRepositoryImpl.findAll().size();

        // Assert
        assertEquals(expectedSize, size);
    }

    @Test
    public void findAllByNameContainsReturnsPersonajesWithNameContainingQuery() {
        // Arrange
        String query = "darth";
        int expectedSize = 2;
        List<String> expectedNames = List.of("Darth Vader", "Darth Maul");

        // Act
        List<Personaje> personajes = personajesRepositoryImpl.findAllByNameContains(query);
        int size = personajes.size();
        List<String> names = personajes.stream().map(Personaje::getName).toList();

        // Assert
        assertEquals(expectedSize, size);
        assertEquals(expectedNames, names);
    }
}
