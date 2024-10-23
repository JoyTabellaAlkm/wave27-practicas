package ar.com.mercadolibre.moviesConsultas.exception;

import ar.com.mercadolibre.moviesConsultas.model.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponse> notFoundException(NotFoundException ex){
        MessageResponse response = new MessageResponse(ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }
}
