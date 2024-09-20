package com.mercadolibre.calculadoredad.services.impl;

import com.mercadolibre.calculadoredad.services.ICalcularEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class CalcularEdadService implements ICalcularEdad {
    @Override
    public String calcularEdad(String dia, String mes, String anio) {
        DateTimeFormatter fotmatoALaFechaIngresada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIngresada = LocalDate.parse(dia+"/"+mes+"/"+anio, fotmatoALaFechaIngresada);
        LocalDate fechaActual = LocalDate.now();
        Period tiempoTranscurrido = Period.between(fechaIngresada,fechaActual);

        return ""+tiempoTranscurrido.getYears();
    }
}
