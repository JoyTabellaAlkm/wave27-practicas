package com.mercadolibre.obrasliterariaselasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obrasliterarias", createIndex = true)
@Data
public class ObraLiteraria {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;
}
