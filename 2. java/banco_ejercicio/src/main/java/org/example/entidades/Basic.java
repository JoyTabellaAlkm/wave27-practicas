package org.example.entidades;

public class Basic extends Cliente {
    public Basic() {
        this.nombre = "Basico";
    }
    @Override
    public String getNombre() {
        return nombre;
    }
}
