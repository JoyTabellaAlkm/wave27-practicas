package com.bootcamp.obrasliterarias.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "obras-literarias")
@Data
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    @Field(name = "cantidad_de_paginas")
    private int cantidadDePaginas;
    private String editorial;
    @Field(name = "anio_primera_publicacion")
    private int anioPrimeraPublicacion;
}
