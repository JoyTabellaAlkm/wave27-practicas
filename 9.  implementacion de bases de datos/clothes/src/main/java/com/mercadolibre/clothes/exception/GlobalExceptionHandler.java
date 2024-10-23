package com.mercadolibre.clothes.exception;

import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponse> notFoundException(NotFoundException exception){
        MessageResponse response = new MessageResponse(exception.getMessage());
        return ResponseEntity.status(404).body(response);
    }
}
