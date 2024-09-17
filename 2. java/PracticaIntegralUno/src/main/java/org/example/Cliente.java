package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", DNI: " + dni;
    }
}
