package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double costoUnitario;


}
