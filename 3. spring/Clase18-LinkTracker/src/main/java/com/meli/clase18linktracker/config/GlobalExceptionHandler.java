package com.meli.clase18linktracker.config;

import com.meli.clase18linktracker.dto.ExceptionDTO;
import com.meli.clase18linktracker.exception.InvalidLinkException;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler (InvalidLinkException.class)
    public ResponseEntity<?> invalidLink(InvalidLinkException linkInvalid) {
        ExceptionDTO exception = new ExceptionDTO(HttpStatus.BAD_REQUEST, linkInvalid.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (LinkNeedsAuthorization.class)
    public ResponseEntity<?> linkNeedsAuth(Exception e) {
        ExceptionDTO exception = new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (LinkNotFoundException.class)
    public ResponseEntity<?> linkNotFound(Exception e) {
        ExceptionDTO exception = new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
