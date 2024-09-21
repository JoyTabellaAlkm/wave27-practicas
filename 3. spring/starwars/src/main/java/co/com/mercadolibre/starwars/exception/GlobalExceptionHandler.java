package co.com.mercadolibre.starwars.exception;

import co.com.mercadolibre.starwars.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CharactersNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleCharactersNotFoundException(CharactersNotFoundException e){
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage(),404));
    }

    @ExceptionHandler(UnableToUploadFileException.class)
    public ResponseEntity<ExceptionDTO> handleUnableToUploadException(UnableToUploadFileException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(),400));
    }
}
