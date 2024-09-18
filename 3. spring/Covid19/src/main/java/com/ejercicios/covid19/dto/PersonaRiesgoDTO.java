package com.ejercicios.covid19.dto;

public class PersonaRiesgoDTO {
    private String nombreCompletoPersona;
    private Integer edad;
    private Boolean sintomaDeRiesgo;

    public PersonaRiesgoDTO() {
    }

    public PersonaRiesgoDTO(String nombreCompletoPersona, Integer edad, Boolean sintomaDeRiesgo) {
        this.nombreCompletoPersona = nombreCompletoPersona;
        this.edad = edad;
        this.sintomaDeRiesgo = sintomaDeRiesgo;
    }

    public String getNombreCompletoPersona() {
        return nombreCompletoPersona;
    }

    public void setNombreCompletoPersona(String nombreCompletoPersona) {
        this.nombreCompletoPersona = nombreCompletoPersona;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getSintomaDeRiesgo() {
        return sintomaDeRiesgo;
    }

    public void setSintomaDeRiesgo(Boolean sintomaDeRiesgo) {
        this.sintomaDeRiesgo = sintomaDeRiesgo;
    }
}
