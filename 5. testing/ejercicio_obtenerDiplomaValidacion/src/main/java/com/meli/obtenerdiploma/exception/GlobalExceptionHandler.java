package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDto("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
                        e.getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage).collect(Collectors.toList())
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> validationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDto("Se encontraron los siguientes errores en las validaciones en el PathVariable y RequestParam ",
                        e.getConstraintViolations().stream()
                                .map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )

        );
    }
}
