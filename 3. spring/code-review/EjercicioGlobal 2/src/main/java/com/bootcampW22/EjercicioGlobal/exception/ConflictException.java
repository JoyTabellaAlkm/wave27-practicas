package com.bootcampW22.EjercicioGlobal.exception;

public class ConflictException extends RuntimeException{
    String message;
    public ConflictException(String message){
        super(message);
    }
}
