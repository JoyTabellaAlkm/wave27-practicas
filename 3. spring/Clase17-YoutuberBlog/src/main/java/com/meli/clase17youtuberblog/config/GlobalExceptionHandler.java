package com.meli.clase17youtuberblog.config;

import com.meli.clase17youtuberblog.dto.ExceptionDTO;
import com.meli.clase17youtuberblog.exception.ExistingBlogException;
import com.meli.clase17youtuberblog.exception.NonExistingBlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistingBlogException.class)
    public ResponseEntity<?> existingBlogException(ExistingBlogException existingBlogException) {
        ExceptionDTO exception = new ExceptionDTO(HttpStatus.BAD_REQUEST, existingBlogException.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonExistingBlogException.class)
    public ResponseEntity<?> nonExistingBlogException(NonExistingBlogException nonExistingBlogException) {
        ExceptionDTO exception = new ExceptionDTO(HttpStatus.NOT_FOUND, nonExistingBlogException.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

}
