package ar.com.mercadolibre.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
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

    @NotNull(message = "El id no puede ser vacio.")
    @Positive(message = "El ID debe ser mayor a cero.")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacia.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductRequestDTO product;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @NotNull(message = "El campo no puede estar vacío.")
    private Double price;
}