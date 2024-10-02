package com.edad.Clase13_Edad.controller;
import com.edad.Clase13_Edad.dto.FechaInvalidaDTO;
import com.edad.Clase13_Edad.exceptions.FechaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.edad.Clase13_Edad.service.IEdad;

@RestController
public class EdadController {

    @Autowired
    IEdad IEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public long obtenerEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) throws FechaInvalidaException {
        return IEdad.obtenerEdad(dia, mes, anio) ;
    }

    @ExceptionHandler(FechaInvalidaException.class)
    public ResponseEntity<?> fechaInvalidaException(FechaInvalidaException e) {
        FechaInvalidaDTO dto = new FechaInvalidaDTO();

        dto.setMensajeError(e.getMessage());
        dto.setFechaInvalida(e.getFecha());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
