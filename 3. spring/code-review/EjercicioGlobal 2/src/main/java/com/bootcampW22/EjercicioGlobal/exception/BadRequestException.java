package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequestException extends RuntimeException{
    String message;
    public BadRequestException(String message){
        super(message);
    }
}
