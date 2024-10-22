package com.example.qatesters.excepciones;

public class NoFoundException extends RuntimeException {
    public NoFoundException(String message) {
        super(message);
    }
}
