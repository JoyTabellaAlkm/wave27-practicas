package ar.com.mercadolibre.link.exception;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException(String message){
        super(message);
    }
}
