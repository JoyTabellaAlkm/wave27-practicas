package com.bootcamp.obrasliterarias.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras-literarias")
@Data
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidadDePaginas;
    private String editorial;
    private int anioPrimeraPublicacion;
}
