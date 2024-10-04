package co.com.mercadolibre.StarWars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    @JsonProperty("home_world")
    private String homerworld;
    private String species;

}
