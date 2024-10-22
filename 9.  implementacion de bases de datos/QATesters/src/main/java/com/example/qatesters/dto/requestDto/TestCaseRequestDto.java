package com.example.qatesters.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class TestCaseRequestDto {
    @NotEmpty(message = "La descripcion no puede ser vacia")
    String description;
    @NotNull(message = "El tested no puede ser vacia")
    Boolean tested;
    @NotNull(message = "El passed no puede ser vacia")
    Boolean passed;
    @PositiveOrZero(message = "El numero de intentos no puede ser menor que cero")
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @NotNull(message = "La fecha no puede ser vacia")
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}

