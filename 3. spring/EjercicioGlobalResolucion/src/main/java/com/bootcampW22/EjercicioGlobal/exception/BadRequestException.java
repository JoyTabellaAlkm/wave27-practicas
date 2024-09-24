package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("400 Bad Request: Datos del vehículo mal formados o incompletos.");
    }
}
