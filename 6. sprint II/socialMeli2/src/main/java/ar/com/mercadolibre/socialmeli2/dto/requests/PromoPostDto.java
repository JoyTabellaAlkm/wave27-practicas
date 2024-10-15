package ar.com.mercadolibre.socialmeli2.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDto {
    @NotNull(message = "El id del usuario no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    @JsonProperty("product")
    private ProductDto product;

    @NotNull(message = "La categoria no puede estar vacía")
    private Integer category;

    @NotNull(message = "El precio no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

    @AssertTrue(message = "El campo has_promo debe ser verdadero")
    @NotNull(message = "El campo has_promo no puede estar vacío")
    @JsonProperty("has_promo")
    private Boolean hasPromo;

    @NotNull(message = "El descuento no puede estar vacío")
    @Positive(message = "El descuento debe ser mayor a cero")
    private Double discount;
}
