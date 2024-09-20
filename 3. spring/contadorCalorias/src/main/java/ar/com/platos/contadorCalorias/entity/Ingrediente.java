package ar.com.platos.contadorCalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingrediente {

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("calories")
    private Integer calorias;

    public Ingrediente(String nombre, Integer calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }
}
