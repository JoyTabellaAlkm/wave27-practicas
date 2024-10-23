package com.mercadolibre.obrasliterarias.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
@AllArgsConstructor @NoArgsConstructor @Data
public class ObraLiterariaResponseDTO {
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_paginas")
    private Integer cantidadPaginas;
    private String editorial;
    @JsonProperty("año_primera_publicacion")
    private Integer anioPrimeraPublicacion;
}
