package ar.com.autosusados.autosusados.config;

import ar.com.autosusados.autosusados.dtos.ExceptionDTO;
import ar.com.autosusados.autosusados.exceptions.CrearRegistroException;
import ar.com.autosusados.autosusados.exceptions.NoSeEncontroELAutoIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CrearRegistroException.class)
    public ResponseEntity<ExceptionDTO> crearRegistroException(CrearRegistroException ex) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSeEncontroELAutoIdException.class)
    public ResponseEntity<ExceptionDTO> noSeEncontroAutoPorIdException(NoSeEncontroELAutoIdException ex) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
