package com.mercadolibre.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        try{
            this.height = Integer.parseInt(height);
        }catch (Exception e){
            this.height = null;
        }

        try{
            this.mass = Integer.parseInt(mass);
        }catch (Exception e){
            this.mass = null;
        }

        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}