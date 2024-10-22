package com.mercadolibre.obrasliterariaselasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaRequestDTO {
    private String id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;
}
