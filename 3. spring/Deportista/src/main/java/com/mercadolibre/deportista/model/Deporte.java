package com.mercadolibre.deportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private int id;
    private String nombre;
    private String nivel;
}
