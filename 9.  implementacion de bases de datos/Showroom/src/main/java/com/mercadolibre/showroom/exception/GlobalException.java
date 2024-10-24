package com.mercadolibre.showroom.exception;

import com.mercadolibre.showroom.dto.ErrorDTO;
import com.mercadolibre.showroom.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class GlobalException{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException e){
        return new ResponseEntity<>(new ResponseDTO(404, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorDTO("Error en las validaciones", List.of(Objects.requireNonNull(e.getMessage()))),HttpStatus.BAD_REQUEST);
    }
}
