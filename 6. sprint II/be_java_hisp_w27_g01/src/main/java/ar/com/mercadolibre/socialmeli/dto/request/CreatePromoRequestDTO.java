package ar.com.mercadolibre.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePromoRequestDTO {


    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductRequestDTO product;

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "La categoria debe ser mayor a cero.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @Positive(message = "El precio debe ser mayor a cero.")
    private Double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    @DecimalMax(value = "0.51")
    private Double discount;
}
