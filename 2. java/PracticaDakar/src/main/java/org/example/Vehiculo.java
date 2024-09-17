package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;


}
