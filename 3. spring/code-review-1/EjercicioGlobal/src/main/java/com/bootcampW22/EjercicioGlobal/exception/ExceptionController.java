package com.bootcampW22.EjercicioGlobal.exception;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ValidationException.class, MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public ResponseEntity<?> badRequest(Exception e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(ExistingIdException.class)
    public ResponseEntity<?> conflict(ExistingIdException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DimensionParseException.class)
    public ResponseEntity<?> unprocessableEntity(DimensionParseException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
