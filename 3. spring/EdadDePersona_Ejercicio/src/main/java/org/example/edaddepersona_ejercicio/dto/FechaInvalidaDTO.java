package org.example.edaddepersona_ejercicio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class FechaInvalidaDTO {
    private String mensajeError;
    private LocalDate fechaInvalida;
}
