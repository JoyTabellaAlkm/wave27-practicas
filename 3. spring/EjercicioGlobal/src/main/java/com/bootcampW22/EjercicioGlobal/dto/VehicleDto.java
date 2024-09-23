package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @Positive
    private Long id;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String registration;
    @NotBlank
    private String color;
    @Positive
    private int year;
    @NotBlank
    private String max_speed;
    @Positive
    private int passengers;
    @NotBlank
    private String fuel_type;
    @NotBlank
    private String transmission;
    @Positive
    private double height;
    @Positive
    private double width;
    @Positive
    private double weight;
}
