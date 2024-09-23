package co.mercadolibre.covid.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sintoma {
    private int codigo;
    private String nombre;

    @JsonProperty("nivel_gravedad")
    private String nivelGravedad;

    public Sintoma(int codigo, String nombre, String nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(String nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
