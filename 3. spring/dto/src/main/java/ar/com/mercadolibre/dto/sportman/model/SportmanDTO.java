package ar.com.mercadolibre.dto.sportman.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SportmanDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String sportName;
}
