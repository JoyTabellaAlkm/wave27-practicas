package ar.com.linktracker.demo.config;

import ar.com.linktracker.demo.dtos.ExceptionDTO;
import ar.com.linktracker.demo.exceptions.LinkInvalidExceptions;
import ar.com.linktracker.demo.exceptions.LinkNeedsAuthorizationException;
import ar.com.linktracker.demo.exceptions.LinkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGenericException(Exception linkNotFound) {
        ExceptionDTO dto = new ExceptionDTO(linkNotFound.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleLinkNotFound(LinkNotFoundException linkNotFound) {
        ExceptionDTO dto = new ExceptionDTO(linkNotFound.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkInvalidExceptions.class)
    public ResponseEntity<ExceptionDTO> handleLinkIsInvalid(LinkInvalidExceptions linkIsInvalid) {
        ExceptionDTO dto = new ExceptionDTO(linkIsInvalid.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNeedsAuthorizationException.class)
    public ResponseEntity<ExceptionDTO> handleLinkIsInvalid(LinkNeedsAuthorizationException linkNeedsAuthorization) {
        ExceptionDTO dto = new ExceptionDTO(linkNeedsAuthorization.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.UNAUTHORIZED);
    }
}