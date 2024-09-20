package ar.com.platos.contadorCalorias.entity;

import java.util.List;

public class Plato {
    private String nombre;
    private Integer peso;
    private List<Ingrediente> ingredientes;

    public Plato(String nombre, Integer peso, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.peso = peso;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
