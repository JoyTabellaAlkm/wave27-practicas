package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorDTO errorDTO = new ErrorDTO("El vehículo tiene campos incompletos", ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()));
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException ex){
        ErrorDTO errorDTO = new ErrorDTO("Error", List.of(Objects.requireNonNull(ex.getMessage())));
        return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
    }

}
