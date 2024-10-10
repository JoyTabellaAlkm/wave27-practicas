package ar.com.mercadolibre.socialmeli.exception;

import ar.com.mercadolibre.socialmeli.dto.exception.ExceptionDTO;
import ar.com.mercadolibre.socialmeli.dto.exception.ValidationResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception ex){
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException ex){
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException ex){
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationResponseDTO>> invalidArg(MethodArgumentNotValidException ex) {

        List<ValidationResponseDTO> errors = ex.getFieldErrors()
                .stream()
                .map(argument -> ValidationResponseDTO.builder()
                        .rejectedValue(argument.getRejectedValue())
                        .argument(argument.getField())
                        .message(argument.getDefaultMessage())
                        .build())
                .toList();

        return ResponseEntity.badRequest()
                .body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidationResponseDTO>> handleConstraintViolation(ConstraintViolationException ex) {
        List<ValidationResponseDTO> errors = ex.getConstraintViolations().stream()
                .map(violation -> ValidationResponseDTO.builder()
                        .argument(violation.getPropertyPath().toString())
                        .message(violation.getMessage())
                        .rejectedValue(violation.getInvalidValue())
                        .build())
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }



}
