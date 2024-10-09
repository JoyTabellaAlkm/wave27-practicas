package org.mercadolibre.ejerciciodeportista.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Deporte {
    private long id;
    private String nombre;
    private String nivel;
}
