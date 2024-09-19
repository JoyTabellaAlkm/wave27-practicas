package com.mercadolibre.practicadeportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;
}
