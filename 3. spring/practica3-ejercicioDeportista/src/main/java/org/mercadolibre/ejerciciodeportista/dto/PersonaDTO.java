package org.mercadolibre.ejerciciodeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.ejerciciodeportista.entity.Deporte;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
