package com.meli.clase18linktracker.exception;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException() {
        super("El link no existe");
    }
}
