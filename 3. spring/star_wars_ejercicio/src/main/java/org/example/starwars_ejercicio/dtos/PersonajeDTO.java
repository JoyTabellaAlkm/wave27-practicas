package org.example.starwars_ejercicio.dtos;

import lombok.Data;

@Data
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
