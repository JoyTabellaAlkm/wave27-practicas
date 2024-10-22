package com.mercadolibre.seguroautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VehiculoSiniestroInfoTotalDTO {
    List<VehiculoSiniestroInfoDTO> vehiculos;
    Double total;
}

