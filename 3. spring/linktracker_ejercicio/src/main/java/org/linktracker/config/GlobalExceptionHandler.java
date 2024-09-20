package org.linktracker.config;

import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Todo deberia ser DTOs ResponseEntity<ExceptionDTO>

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception linkNotFound) {
        return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<String> handleLinkNotFound(LinkNotFound linkNotFound) {
        return new ResponseEntity<>(linkNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkIsInvalid.class)
    public ResponseEntity<String> handleLinkIsInvalid(LinkIsInvalid linkIsInvalid) {
        return new ResponseEntity<>(linkIsInvalid.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNeedsAuthorization.class)
    public ResponseEntity<String> handleLinkIsInvalid(LinkNeedsAuthorization linkNeedsAuthorization) {
        return new ResponseEntity<>(linkNeedsAuthorization.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
