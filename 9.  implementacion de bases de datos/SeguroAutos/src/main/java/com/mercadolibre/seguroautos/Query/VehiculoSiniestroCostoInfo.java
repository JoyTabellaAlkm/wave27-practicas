package com.mercadolibre.seguroautos.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroCostoInfo {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaEconomica;
}

