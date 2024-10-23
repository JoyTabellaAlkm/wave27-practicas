package ar.com.mercadolibre.moviesConsultas.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
