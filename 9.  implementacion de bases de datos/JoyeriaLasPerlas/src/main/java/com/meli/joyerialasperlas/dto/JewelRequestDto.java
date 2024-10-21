package com.meli.joyerialasperlas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelRequestDto {
    @NotBlank
    private String nombre;

    @NotBlank
    private String material;

    @NotNull
    private Double peso;

    @NotBlank
    private String particularidad;

    @NotNull
    private Boolean poseePiedra;
}
