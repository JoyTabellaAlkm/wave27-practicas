package co.com.mercadolibre.starwars.exception;

public class UnableToUploadFileException extends RuntimeException {
    public UnableToUploadFileException(String message) {
        super(message);
    }
}
