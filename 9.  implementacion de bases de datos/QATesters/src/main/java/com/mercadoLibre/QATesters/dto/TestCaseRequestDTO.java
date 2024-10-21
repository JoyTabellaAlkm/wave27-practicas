package com.mercadoLibre.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseRequestDTO {
    @NotEmpty(message = "La descripción no puede estar vacía")
    private String description;
    @NotNull(message = "El campo tested no puede estar vacío")
    private Boolean tested;
    @NotNull(message = "El campo passed no puede estar vacío")
    private Boolean passed;
    @JsonProperty(value = "number_of_tries")
    @PositiveOrZero(message = "El valor debe ser mayor o igual a 0")
    private int numberOfTries;
    @JsonProperty(value = "last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate lastUpdate;
}
