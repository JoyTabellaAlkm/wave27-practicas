package ar.com.mercadolibre.link.exception;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException(String message){
        super(message);
    }

}
