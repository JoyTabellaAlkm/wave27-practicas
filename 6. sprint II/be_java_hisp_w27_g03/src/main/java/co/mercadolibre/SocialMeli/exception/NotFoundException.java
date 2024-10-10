package co.mercadolibre.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
