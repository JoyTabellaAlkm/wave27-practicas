package com.mercadoLibre.HQLSeguroAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroRequestDTO {
    private String fecha;
    private Double perdida;
    private String vehiculoDenunciado;
}
