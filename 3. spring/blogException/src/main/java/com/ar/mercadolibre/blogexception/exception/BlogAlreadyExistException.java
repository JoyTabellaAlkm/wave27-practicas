package com.ar.mercadolibre.blogexception.exception;

public class BlogAlreadyExistException extends RuntimeException {
    public BlogAlreadyExistException() {}

    public BlogAlreadyExistException(String message) {
        super(message);
    }
}
