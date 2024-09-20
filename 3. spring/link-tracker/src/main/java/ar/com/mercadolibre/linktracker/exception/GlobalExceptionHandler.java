package ar.com.mercadolibre.linktracker.exception;

import ar.com.mercadolibre.linktracker.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception ex) {
        return ResponseEntity.internalServerError().body(new ExceptionDto("Ocurrió un error en el servidor.", 500));
    }

    @ExceptionHandler(IdCreationException.class)
    public ResponseEntity<ExceptionDto> handleIdCreationException(IdCreationException ex) {
        return ResponseEntity.internalServerError().body(new ExceptionDto(ex.getMessage(), 500));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(ex.getMessage(), 404));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionDto> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionDto(ex.getMessage(), 401));
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionDto> handleInvalidLinkException(InvalidLinkException ex) {
        return ResponseEntity.status(HttpStatus.GONE).body(new ExceptionDto(ex.getMessage(), 410));
    }
}
