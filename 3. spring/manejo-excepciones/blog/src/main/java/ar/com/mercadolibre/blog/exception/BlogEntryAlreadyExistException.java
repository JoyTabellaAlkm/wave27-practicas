package ar.com.mercadolibre.blog.exception;

public class BlogEntryAlreadyExistException extends RuntimeException{

    public BlogEntryAlreadyExistException(){}

    public BlogEntryAlreadyExistException(String message){
        super(message);
    }
}
