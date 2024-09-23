package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VelocityDTO {
    @Positive
    private String max_speed;
}
