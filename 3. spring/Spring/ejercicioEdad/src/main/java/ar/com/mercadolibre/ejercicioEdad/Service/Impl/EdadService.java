package ar.com.mercadolibre.ejercicioEdad.Service.Impl;
import ar.com.mercadolibre.ejercicioEdad.Service.IEdad;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class EdadService implements IEdad {

    @Override
    public int devolverEdad(int dia, int mes, int anio){
        LocalDate fechaActual = LocalDate.now();
        int diaActual = fechaActual.getDayOfMonth();
        int mesActual = fechaActual.getMonth().getValue();
        int anioActual = fechaActual.getYear();

        int anioEdad = anioActual - anio;

        if(mesActual < mes || (mesActual == mes && diaActual < dia)){
            return  anioEdad - 1;
        }
        else{
            return anioEdad;
        }
    }

}
