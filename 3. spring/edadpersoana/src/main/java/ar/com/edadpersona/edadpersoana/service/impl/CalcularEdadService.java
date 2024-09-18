package ar.com.edadpersona.edadpersoana.service.impl;

import ar.com.edadpersona.edadpersoana.service.ICalcularEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class CalcularEdadService implements ICalcularEdadService {

    @Override
    public String calcularEdad(String dia, String mes, String anio) {

        DateTimeFormatter fotmatoALaFechaIngresada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIngresada = LocalDate.parse(dia+"/"+mes+"/"+anio, fotmatoALaFechaIngresada);
        LocalDate fechaDeHoy = LocalDate.now();

        Period tiempoTranscurrido = Period.between(fechaIngresada,fechaDeHoy);

        return "Tenes: " + tiempoTranscurrido.getYears() + " años";
    }
}
