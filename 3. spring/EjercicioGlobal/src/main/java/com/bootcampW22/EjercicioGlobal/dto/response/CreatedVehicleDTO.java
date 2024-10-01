package com.bootcampW22.EjercicioGlobal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedVehicleDTO {
    private Long id;
    private String brand;
    private String model;
}
