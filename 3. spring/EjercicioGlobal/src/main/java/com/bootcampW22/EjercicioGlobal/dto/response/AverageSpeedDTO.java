package com.bootcampW22.EjercicioGlobal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageSpeedDTO {
    private String brand;
    private Double average_speed;

}
