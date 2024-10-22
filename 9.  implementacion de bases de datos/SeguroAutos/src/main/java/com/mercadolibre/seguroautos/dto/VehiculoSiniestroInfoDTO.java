package com.mercadolibre.seguroautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroInfoDTO {
    private String patente;
    private String marca;
    private String modelo;
}

