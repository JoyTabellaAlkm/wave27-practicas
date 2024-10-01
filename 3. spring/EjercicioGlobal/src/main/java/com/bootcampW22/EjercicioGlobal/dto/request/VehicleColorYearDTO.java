package com.bootcampW22.EjercicioGlobal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleColorYearDTO {
    private String color;
    private int year;
}
