package com.mercadolibre.seguroautos.dto;

import lombok.Data;

@Data
public class PatenteYMarcaResponseDto {
    private Long id;
    private String patente;
    private String marca;
}
