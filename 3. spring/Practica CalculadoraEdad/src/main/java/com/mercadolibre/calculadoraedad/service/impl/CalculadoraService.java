package com.mercadolibre.calculadoraedad.service.impl;

import com.mercadolibre.calculadoraedad.service.ICalculadoraService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class CalculadoraService implements ICalculadoraService {
    @Override
    public String calcular(String dia, String mes, String anio) {
        LocalDate fechaDeHoy = LocalDate.now();
        DateTimeFormatter fotmatoALaFechaIngresada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIngresada = LocalDate.parse(dia+"/"+mes+"/"+anio, fotmatoALaFechaIngresada);
        Period tiempoTranscurrido = Period.between(fechaIngresada,fechaDeHoy);
        return "Tenes: " + tiempoTranscurrido.getYears() + " años";
    }
}
