package com.edad.Clase13_Edad.exceptions;
import java.time.LocalDate;

public class FechaInvalidaException extends Exception {
    private LocalDate fecha;

    public FechaInvalidaException(LocalDate fecha) {
        super("Fecha invalida");
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
