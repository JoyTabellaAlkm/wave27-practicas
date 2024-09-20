package org.example.youtuberblog_ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice        (annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BlogAlreadyExists.class)
    public ResponseEntity<?> blogAlreadyExists(BlogAlreadyExists blogAlreadyExists) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(blogAlreadyExists.getMessage());
    }

    @ExceptionHandler(value = BlogDoesntExist.class)
    public ResponseEntity<?> blogDoesntExist(BlogDoesntExist blogDoesntExist) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(blogDoesntExist.getMessage());
    }
}
