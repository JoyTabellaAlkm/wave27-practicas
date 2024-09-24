package com.w27.exceptionsblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "El id ingresado no es válido")
public class IllegalIdException extends RuntimeException {
    public IllegalIdException(String message) {
        super(message);
    }
}
