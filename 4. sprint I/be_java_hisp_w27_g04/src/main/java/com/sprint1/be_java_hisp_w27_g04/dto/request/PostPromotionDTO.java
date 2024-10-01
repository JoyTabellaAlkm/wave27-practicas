package com.sprint1.be_java_hisp_w27_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w27_g04.dto.request.ProductDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromotionDTO {
    @NotNull
    @JsonProperty(value = "user_id")
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date; // Usa LocalDate para manejar la fecha
    @NotNull
    private ProductDTO product; // Relación con ProductDTO
    @NotNull
    private int category;
    @NotNull
    private double price;
    @NotNull
    @JsonProperty(value = "has_promo")
    private boolean hasPromo;
    @NotNull
    private double discount;
}
