package com.bootcampW22.EjercicioGlobal.exception;

public class ConflictException extends RuntimeException {
    public ConflictException() {
        super("409 Conflict: Identificador del vehículo.");
    }
}
