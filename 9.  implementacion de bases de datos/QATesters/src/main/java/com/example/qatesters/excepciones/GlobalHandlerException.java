package com.example.qatesters.excepciones;

import com.example.qatesters.dto.responseDTO.ResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> noFoundException(NoFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)  {
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ResponseDto dto = new ResponseDto(HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
