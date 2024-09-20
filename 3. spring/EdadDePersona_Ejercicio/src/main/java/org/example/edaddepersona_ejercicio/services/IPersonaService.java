package org.example.edaddepersona_ejercicio.services;

import org.example.edaddepersona_ejercicio.exceptions.FechaInvalidaException;

import java.time.LocalDate;

public interface IPersonaService {
    Long CalcularEdad(LocalDate birthDate) throws FechaInvalidaException;
}
