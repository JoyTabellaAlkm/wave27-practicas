package org.example.entidades;

public class Cobrador extends Cliente{
    public Cobrador(){
        this.nombre = "Cobrador";
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
