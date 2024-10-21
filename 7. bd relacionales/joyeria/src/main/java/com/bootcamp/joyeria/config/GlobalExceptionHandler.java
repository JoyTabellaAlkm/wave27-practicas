package com.bootcamp.joyeria.config;

import com.bootcamp.joyeria.dto.ExceptionDto;
import com.bootcamp.joyeria.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception e) {
        System.out.println("Exception: " + e.getMessage());
        return ResponseEntity.internalServerError().body(new ExceptionDto(500, e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e) {
        System.out.println("NotFoundException: " + e.getMessage());
        return new ResponseEntity<>(new ExceptionDto(404, e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
