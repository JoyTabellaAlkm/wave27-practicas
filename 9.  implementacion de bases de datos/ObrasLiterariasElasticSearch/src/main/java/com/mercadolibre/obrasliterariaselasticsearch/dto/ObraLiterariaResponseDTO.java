package com.mercadolibre.obrasliterariaselasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaResponseDTO {
    private String titulo;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;
}
