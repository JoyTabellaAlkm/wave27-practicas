package ar.com.mercadolibre.calcularedad.services.impl;

import ar.com.mercadolibre.calcularedad.services.ICalcularEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadServiceImpl implements ICalcularEdadService {


    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fecha= LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        return Period.between(fecha, fechaActual).getYears();
    }

}
