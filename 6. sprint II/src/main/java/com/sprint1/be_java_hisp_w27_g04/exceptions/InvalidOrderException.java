package com.sprint1.be_java_hisp_w27_g04.exceptions;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
