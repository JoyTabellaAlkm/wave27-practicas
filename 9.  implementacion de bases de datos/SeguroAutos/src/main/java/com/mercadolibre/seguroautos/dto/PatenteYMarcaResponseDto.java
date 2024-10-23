package com.mercadolibre.seguroautos.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteYMarcaResponseDto {
    private String patente;
    private String marca;
}
