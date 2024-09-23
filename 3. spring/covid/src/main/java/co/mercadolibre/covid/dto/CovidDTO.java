package co.mercadolibre.covid.dto;

import co.mercadolibre.covid.entity.Sintoma;

public class CovidDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;

    public CovidDTO(String nombre, String apellido, int edad, Sintoma sintoma) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintoma = sintoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
}
