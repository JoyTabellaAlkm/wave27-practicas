package com.sprint1.be_java_hisp_w27_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    @JsonProperty(value = "user_id")
    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;


    private @Valid @NotNull ProductDTO product;

    @NotNull(message = "El campo no puede estar vacio")
    private int category;

    @NotNull(message = "El campo no puede estar vacio")
    @Max(message = "El precio maximo por producto es de 10.000.000", value = 10000000)
    private double price;
}
