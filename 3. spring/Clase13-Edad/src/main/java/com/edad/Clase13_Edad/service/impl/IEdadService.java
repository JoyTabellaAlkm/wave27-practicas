package com.edad.Clase13_Edad.service.impl;

import com.edad.Clase13_Edad.exceptions.FechaInvalidaException;
import com.edad.Clase13_Edad.service.IEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@Service
public class IEdadService implements IEdad {
    @Override
    public long obtenerEdad(Integer dia, Integer mes, Integer anio) throws FechaInvalidaException{
        LocalDate fechaNacimiento = LocalDate.of(anio, Month.of(mes), dia);
        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new FechaInvalidaException(fechaNacimiento);
        }
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

}
