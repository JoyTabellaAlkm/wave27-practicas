package com.bootcampW22.EjercicioGlobal.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("404 Not Found: No se encontraron vehículos con esos criterios.");
    }
}
