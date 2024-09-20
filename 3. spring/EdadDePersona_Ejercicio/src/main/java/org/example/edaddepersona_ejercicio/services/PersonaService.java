package org.example.edaddepersona_ejercicio.services;

import org.example.edaddepersona_ejercicio.exceptions.FechaInvalidaException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class PersonaService implements IPersonaService {
    @Override
    public Long CalcularEdad(LocalDate birthDate) throws FechaInvalidaException {
        var fechaActual = LocalDate.now();
        if(fechaActual.isBefore(birthDate)){
            throw new FechaInvalidaException(birthDate);
        }

        Long resultado = ChronoUnit.YEARS.between(birthDate, fechaActual);
        return resultado;
    }
}
