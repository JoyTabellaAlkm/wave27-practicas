package ar.com.mercadolibre.socialmeli2.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacia")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    @JsonProperty("product")
    private ProductDto product;

    @NotNull(message = "La categoria no puede estar vacia")
    @Positive(message = "La categoria debe ser mayor a cero")
    private Integer category;

    @NotNull(message = "El precio no puede estar vacio")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
