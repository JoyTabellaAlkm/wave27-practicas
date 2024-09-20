package com.mercadolibre.blog.exceptions;

public class BlogEntryDoesNotExistsException extends RuntimeException{

    public BlogEntryDoesNotExistsException() {
    }

    public BlogEntryDoesNotExistsException(String message) {
        super(message);
    }
}
