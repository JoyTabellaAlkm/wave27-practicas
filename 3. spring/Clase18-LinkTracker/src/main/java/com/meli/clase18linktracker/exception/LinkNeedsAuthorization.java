package com.meli.clase18linktracker.exception;

public class LinkNeedsAuthorization extends RuntimeException {
    public LinkNeedsAuthorization() {
        super("Ingrese la contraseña para acceder al link");
    }
}
