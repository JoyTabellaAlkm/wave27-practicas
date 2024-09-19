package com.ejercicios.edadpersona.service.impl;

import com.ejercicios.edadpersona.service.IObtenerEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ObtenerEdadServiceImpl implements IObtenerEdadService {
    @Override
    public Integer obtenerEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        return Period.between(fechaActual, fechaNacimiento).getYears();
    }
}
