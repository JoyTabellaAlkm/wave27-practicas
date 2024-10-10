package com.sprint1.be_java_hisp_w27_g04.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
