package ar.com.mercadolibre.starwars.controller;

import ar.com.mercadolibre.starwars.service.PersonajesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PersonajesControllerTests {

    @Mock
    private PersonajesService personajesService;

    @InjectMocks
    private PersonajesController personajesController;

    @Test
    public void getFilteredShouldCallService() {
        // Arrange
        int expectedCalls = 1;

        // Act
        personajesController.getFiltered("nombre");

        // Assert
        verify(personajesService, times(expectedCalls)).getFiltered(anyString());
    }

    @Test
    public void getFilteredShouldSendNameIfNotNull() {
        // Arrange
        String name = "darth";

        // Act
        personajesController.getFiltered(name);

        // Assert
        verify(personajesService).getFiltered(name);
    }

    @Test
    public void getFilteredShouldSendEmptyStringIfNull() {
        // Arrange
        String name = null;

        // Act
        personajesController.getFiltered(name);

        // Assert
        verify(personajesService).getFiltered("");
    }
}
