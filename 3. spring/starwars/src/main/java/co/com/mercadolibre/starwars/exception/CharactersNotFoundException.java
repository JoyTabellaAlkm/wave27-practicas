package co.com.mercadolibre.starwars.exception;

public class CharactersNotFoundException extends RuntimeException {
    public CharactersNotFoundException(String message) {
        super(message);
    }
}
