package com.ejercicio.starwars.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hair_color")
    private String hairColour;
    @JsonProperty("skin_color")
    private String skinColour;
    @JsonProperty("eye_color")
    private String eyeColour;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
