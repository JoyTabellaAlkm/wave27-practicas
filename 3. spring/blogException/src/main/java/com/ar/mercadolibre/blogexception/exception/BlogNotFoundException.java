package com.ar.mercadolibre.blogexception.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(){}

    public BlogNotFoundException(String msg) {
        super(msg);
    }
}
