package com.edad.Clase14_Deportistas.exceptions;

import com.edad.Clase14_Deportistas.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(), HttpStatus.OK);
        return new ResponseEntity<>(exceptionDto, HttpStatus.OK);
    }
}
