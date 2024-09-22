package org.linktracker.config;

import org.linktracker.dtos.ExceptionDTO;
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
    public ResponseEntity<ExceptionDTO> handleGenericException(Exception linkNotFound) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionDTO ex = new ExceptionDTO("Server error",status.value());
        return new ResponseEntity<>(ex, status);
    }

    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<ExceptionDTO> handleLinkNotFound(LinkNotFound linkNotFound) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionDTO ex = new ExceptionDTO("Link has not been found.",status.value());
        return new ResponseEntity<>(ex, status);
    }

    @ExceptionHandler(LinkIsInvalid.class)
    public ResponseEntity<ExceptionDTO> handleLinkIsInvalid(LinkIsInvalid linkIsInvalid) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDTO ex = new ExceptionDTO("Link is invalid.",status.value());
        return new ResponseEntity<>(ex, status);
    }

    @ExceptionHandler(LinkNeedsAuthorization.class)
    public ResponseEntity<ExceptionDTO> handleLinkIsInvalid(LinkNeedsAuthorization linkNeedsAuthorization) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionDTO ex = new ExceptionDTO("Authorization failed for the link.",status.value());
        return new ResponseEntity<>(ex, status);
    }
}
