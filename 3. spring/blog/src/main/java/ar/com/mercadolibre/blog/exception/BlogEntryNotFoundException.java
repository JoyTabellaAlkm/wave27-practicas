package ar.com.mercadolibre.blog.exception;

public class BlogEntryNotFoundException extends RuntimeException{

    public BlogEntryNotFoundException(){}

    public BlogEntryNotFoundException(String message){
        super(message);
    }
}
