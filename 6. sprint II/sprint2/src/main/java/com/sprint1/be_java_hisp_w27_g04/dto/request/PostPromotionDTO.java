package com.sprint1.be_java_hisp_w27_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromotionDTO {
    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty(value = "user_id")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date; // Usa LocalDate para manejar la fecha

    @Valid
    private ProductDTO product; // Relación con ProductDTO

    @NotNull(message = "El campo no puede estar vacio")
    private int category;

    @NotNull(message = "El campo no puede estar vacio")
    @Max(message = "El precio maximo por producto es de 10.000.000", value = 10000000)
    private double price;

    @NotNull
    @JsonProperty(value = "has_promo")
    private boolean hasPromo;

    @NotNull
    private double discount;
}
