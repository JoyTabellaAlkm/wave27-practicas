package com.bootcampW22.EjercicioGlobal.exception;

public class VehicleAlreadyExistException extends RuntimeException{

    public VehicleAlreadyExistException() {
    }

    public VehicleAlreadyExistException(String message) {
        super(message);
    }
}
