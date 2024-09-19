package com.mercadolibre.starwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Personaje implements Serializable {
    private String name;
    private String height;
    private String mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("birth_year")
    private String birthYear;

    private String gender;
    private String homeworld;
    private String species;
}