package com.bootcampW22.EjercicioGlobal.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class VehicleSpeedDTO {
    private Long id;
    private String maxSpeed;
}
