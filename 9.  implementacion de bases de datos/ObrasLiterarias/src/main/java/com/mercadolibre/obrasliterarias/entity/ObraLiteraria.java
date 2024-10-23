package com.mercadolibre.obrasliterarias.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
@AllArgsConstructor @NoArgsConstructor @Data
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    @Field(name = "cantidad_paginas")
    private Integer cantidadPaginas;
    private String editorial;
    @Field(name = "anio_primera_publicacion")
    private Integer anioPrimeraPublicacion;
}
