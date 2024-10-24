package com.meli.obrasliterarias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaDto {
    private Long id;
    private String autor;
    private String titulo;
    @JsonProperty("cantidad_paginas")
    private int cantidadPaginas;
    private String editorial;
    @JsonProperty("anio_publicacion")
    private String anioPublicacion;
}
