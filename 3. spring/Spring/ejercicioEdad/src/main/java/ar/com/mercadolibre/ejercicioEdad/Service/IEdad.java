package ar.com.mercadolibre.ejercicioEdad.Service;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Month;

public interface IEdad {
    int devolverEdad(int dia, int mes, int anio);

}
