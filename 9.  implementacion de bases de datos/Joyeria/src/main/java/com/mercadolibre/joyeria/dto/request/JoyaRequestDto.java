package com.mercadolibre.joyeria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class JoyaRequestDto {
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(min = 2, max = 30)
    String nombre;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(min = 2, max = 30)
    String material;
    @NotNull(message = "El campo no puede estar vacio.")
    @Min(value = 1, message = "El peso minimo por joya es de 1")
    @Max(value = 10000000, message = "El peso máximo por joya es de 10.000.000")
    Integer peso;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(min = 2, max = 60)
    String particularidad;
    @NotNull(message = "El campo no puede estar vacio.")
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;

}
