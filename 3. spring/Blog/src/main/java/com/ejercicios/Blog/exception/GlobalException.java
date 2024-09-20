package com.ejercicios.Blog.exception;

import com.ejercicios.Blog.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalException {

    @ExceptionHandler(BlogIdException.class)
    public ResponseEntity<?> blogIdExceptionHandler(BlogIdException exception){
        return new ResponseEntity(new ExceptionDTO(exception.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> blogNotFoundExceptionHandler(BlogNotFoundException exception){
        return new ResponseEntity(new ExceptionDTO(exception.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
}
