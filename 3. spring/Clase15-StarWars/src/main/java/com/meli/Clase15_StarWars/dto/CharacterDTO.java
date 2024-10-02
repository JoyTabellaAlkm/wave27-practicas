package com.meli.Clase15_StarWars.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDTO {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
