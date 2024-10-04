package ar.com.mercadolibre.ejercicioEdad.service.impl;
import ar.com.mercadolibre.ejercicioEdad.exception.ExceptionParametros;
import ar.com.mercadolibre.ejercicioEdad.service.IEdad;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdad {

    @Override
    public int devolverEdad(int dia, int mes, int anio){
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fechaActual = LocalDate.now();

        if (fechaNacimiento.isAfter(fechaActual)){
            throw new ExceptionParametros("La fecha de nacimiento no puede ser mayor a la actual");
        }

        return Period.between(fechaNacimiento, fechaActual).getYears();

    }

}
