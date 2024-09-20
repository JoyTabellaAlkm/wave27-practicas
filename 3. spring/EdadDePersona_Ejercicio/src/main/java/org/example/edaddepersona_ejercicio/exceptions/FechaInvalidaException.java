package org.example.edaddepersona_ejercicio.exceptions;

import java.time.LocalDate;
import java.util.Date;

public class FechaInvalidaException extends Exception {
    public FechaInvalidaException(LocalDate fecha) {
        super("Fecha invalida");
        this.fecha = fecha;
    }

    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }
}
