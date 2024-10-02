package com.meli.clase16calorias.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private Integer calorias;

}
