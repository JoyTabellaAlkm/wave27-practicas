package com.bootcampW22.EjercicioGlobal.exception;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    /**
     * 404 NOT_FOUND
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    /**
     * 201 CREATED
     */
    @ExceptionHandler(CreatedException.class)
    public ResponseEntity<?> createdException(Exception e){
        ExceptionDto exceptionDto=new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CREATED);
    }


    /**
     * 400 BAD_REQUEST
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e){
        ExceptionDto dto= new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }

    /**
     * 409 CONFLIC
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflictException(Exception e){
        ExceptionDto dto= new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(dto,HttpStatus.CONFLICT);
    }
/*
    @ExceptionHandler(BadRequstException.class)
    public ResponseEntity<?> badRequestException(Exception e){
        ExceptionDto dto= new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
*/
}
