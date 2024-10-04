package co.com.mercadolibre.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
}
