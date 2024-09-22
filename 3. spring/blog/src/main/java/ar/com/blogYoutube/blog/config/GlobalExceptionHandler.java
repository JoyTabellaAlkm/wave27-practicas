package ar.com.blogYoutube.blog.config;

import ar.com.blogYoutube.blog.dto.ExceptionDTO;
import ar.com.blogYoutube.blog.exception.BuscarPorIdException;
import ar.com.blogYoutube.blog.exception.CrearEntradaBlogException;
import ar.com.blogYoutube.blog.exception.IdRegistradaEnEntradaBlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CrearEntradaBlogException.class)
    public ResponseEntity<ExceptionDTO> crearEntradaBlogException(CrearEntradaBlogException ex) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BuscarPorIdException.class)
    public ResponseEntity<ExceptionDTO> buscarEntradaBlogException(BuscarPorIdException ex) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdRegistradaEnEntradaBlogException.class)
    public ResponseEntity<ExceptionDTO> IdRegistradoEnEntradaBlogException(IdRegistradaEnEntradaBlogException ex) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
