package com.mercadoLibre.HQLSeguroAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloResponseDTO {
    private String patente;
    private String marca;
    private String modelo;
}
