package com.mercadolibre.obrasliterarias.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Data
public class ObraLiterariaRequestDTO {
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_paginas")
    private Integer cantidadPaginas;
    private String editorial;
    @JsonProperty("año_primera_publicacion")
    private Integer anioPrimeraPublicacion;
}
