package ar.com.covid.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;
}
