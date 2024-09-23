package ar.com.mercadolibre.ejercicioCovid.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}

