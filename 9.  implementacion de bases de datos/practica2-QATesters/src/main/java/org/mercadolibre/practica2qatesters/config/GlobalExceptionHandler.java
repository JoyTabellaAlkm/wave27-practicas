package org.mercadolibre.practica2qatesters.config;

import org.mercadolibre.practica2qatesters.config.exception.NotFoundException;
import org.mercadolibre.practica2qatesters.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
