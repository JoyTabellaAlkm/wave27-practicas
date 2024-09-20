package org.example.edaddepersona_ejercicio.controllers;

import org.example.edaddepersona_ejercicio.dto.FechaInvalidaDTO;
import org.example.edaddepersona_ejercicio.exceptions.FechaInvalidaException;
import org.example.edaddepersona_ejercicio.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public Long PostDOB(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) throws FechaInvalidaException {
        LocalDate birthDate = LocalDate.parse(anio + "-" + mes + "-" + dia, DateTimeFormatter.ofPattern("yyyy-M-d"));
        return personaService.CalcularEdad(birthDate);
    }

    @ExceptionHandler(FechaInvalidaException.class)
    public ResponseEntity<?> fechaInvalidaException(FechaInvalidaException e) {
        FechaInvalidaDTO dto = new FechaInvalidaDTO();

        dto.setMensajeError(e.getMessage());
        dto.setFechaInvalida(e.getFecha());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
