package com.bootcamp.obrasliterarias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateObraLiterariaDto {
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_de_paginas")
    private int cantidadDePaginas;
    private String editorial;
    @JsonProperty("anio_primera_publicacion")
    private int anioPrimeraPublicacion;
}
