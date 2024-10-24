package ar.com.mercadolibre.clothes.config;

import ar.com.mercadolibre.clothes.dto.response.ExceptionDto;
import ar.com.mercadolibre.clothes.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> internalServerError(Exception ex) {
        ExceptionDto exceptionDto = new ExceptionDto("Ocurrió un error en el servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.internalServerError().body(exceptionDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException ex) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }


}
