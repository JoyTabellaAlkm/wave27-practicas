package com.sprint1.be_java_hisp_w27_g04.exceptions;

import com.sprint1.be_java_hisp_w27_g04.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage(), "404"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> badRequestException(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(), "400"));
    }

    @ExceptionHandler(BadRequestException.class)
    public  ResponseEntity<?> badRequestException(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(),"400"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public  ResponseEntity<?> illegalException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(),"400"));
    }

    @ExceptionHandler(NotInPromotion.class)
    public  ResponseEntity<?> notInPromotion(NotInPromotion e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(),"400"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)  {
        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ExceptionDTO dto = new ExceptionDTO(errors,"400");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<?> constraintViolationException(ConstraintViolationException ex)  {
        List<String> errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
        ExceptionDTO dto = new ExceptionDTO(errors,"400");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderException.class)
    protected ResponseEntity<?> invalidOrderException(InvalidOrderException ex)  {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(),"400");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
