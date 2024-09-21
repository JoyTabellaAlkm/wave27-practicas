package co.com.mercadolibre.calcularcalorias.exception;

import co.com.mercadolibre.calcularcalorias.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(UnableToLoadFileException.class)
    public ResponseEntity<?> handlerUnableToLoadFileException(UnableToLoadFileException e){
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(),400));
}
    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<?> handlerDishNotFoundException(DishNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage(),404));
    }
}
