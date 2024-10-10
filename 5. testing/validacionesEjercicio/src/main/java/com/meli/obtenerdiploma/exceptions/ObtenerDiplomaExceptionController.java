package com.meli.obtenerdiploma.exceptions;
import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice()
public class ObtenerDiplomaExceptionController extends RuntimeException{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)  {
        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ExceptionDTO dto = new ExceptionDTO(400, errors);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<?> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex)  {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
