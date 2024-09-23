package com.bootcampW22.EjercicioGlobal.exception;

public class ExistingIdException extends RuntimeException {
    public ExistingIdException(String message) {
        super(message);
    }
    public ExistingIdException(Long id) {super("The id %d already exists".formatted(id));}
}
