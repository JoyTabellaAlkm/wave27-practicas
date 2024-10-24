package com.meli.showroom.exception;

import com.meli.showroom.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDTO = new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
