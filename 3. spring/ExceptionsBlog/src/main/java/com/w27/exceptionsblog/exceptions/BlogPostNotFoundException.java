package com.w27.exceptionsblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "El post no existe o el id ingresado no es válido")
public class BlogPostNotFoundException extends RuntimeException {
    public BlogPostNotFoundException(String message){
        super(message);
    }
}
