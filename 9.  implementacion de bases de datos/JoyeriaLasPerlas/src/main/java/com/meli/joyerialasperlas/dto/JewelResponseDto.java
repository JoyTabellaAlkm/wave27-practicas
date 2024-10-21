package com.meli.joyerialasperlas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponseDto {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
}
