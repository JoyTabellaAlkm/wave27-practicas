package ar.com.covid.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
}
