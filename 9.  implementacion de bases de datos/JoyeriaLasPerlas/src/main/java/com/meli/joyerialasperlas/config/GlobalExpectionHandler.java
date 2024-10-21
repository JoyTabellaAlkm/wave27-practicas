package com.meli.joyerialasperlas.config;

import com.meli.joyerialasperlas.dto.ExceptionDto;
import com.meli.joyerialasperlas.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExpectionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDTO = new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
