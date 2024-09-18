package com.ejercicios.edadpersona.service.Impl;

import com.ejercicios.edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {
    @Override
    public Integer calcularEdadPersona(int dia, int mes, int anio) {
        LocalDate fechaNac = LocalDate.of(anio,mes,dia);
        LocalDate fechaHoy = LocalDate.now();
        Period edad = Period.between(fechaNac, fechaHoy);
        return  edad.getYears();
    }
}
