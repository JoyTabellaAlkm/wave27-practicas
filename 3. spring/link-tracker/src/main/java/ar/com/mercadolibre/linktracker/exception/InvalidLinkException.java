package ar.com.mercadolibre.linktracker.exception;

public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String message) {
        super(message);
    }
}
