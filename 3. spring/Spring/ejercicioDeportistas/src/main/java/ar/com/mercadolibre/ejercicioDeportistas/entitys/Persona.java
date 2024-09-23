package ar.com.mercadolibre.ejercicioDeportistas.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona extends Deporte{
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
