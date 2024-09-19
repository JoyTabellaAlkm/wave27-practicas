package com.mercadolibre.practicadeportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Deporte {
    private String nombre;
    private int nivel;
}
