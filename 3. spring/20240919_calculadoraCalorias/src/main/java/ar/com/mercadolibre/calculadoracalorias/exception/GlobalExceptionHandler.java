package ar.com.mercadolibre.calculadoracalorias.exception;

import ar.com.mercadolibre.calculadoracalorias.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyIngredientsException.class)
    public ResponseEntity<?> emptyIngredientsException(Exception e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(PlateNotFoundException.class)
    public ResponseEntity<?> plateNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND));
    }
}
