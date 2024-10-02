package com.meli.clase18linktracker.exception;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException() {
        super("El link ingresado no es valido");
    }
}
