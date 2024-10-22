package com.meli.obrasliterarias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "obras_literarias", createIndex = true)
public class ObraLiteraria {
    @Id
    private Long id;

    private String autor;
    private String titulo;
    private int cantidadPaginas;
    private String editorial;
    private String anioPublicacion;
}
