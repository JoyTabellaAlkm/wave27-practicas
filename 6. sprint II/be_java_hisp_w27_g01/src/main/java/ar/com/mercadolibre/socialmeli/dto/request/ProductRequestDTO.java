package ar.com.mercadolibre.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotNull(message = "El id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    @JsonProperty("product_id")
    private Integer productId;

    @NotNull(message = "El campo no puede estar vacío.")
    @Length(max = 40, message = "La longitud no puede superara los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String productName;

    @NotNull(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superara los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotNull(message = "El campo no puede estar vacío.")
    @Length(max = 25, message = "La longitud no puede superara los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotNull(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superara los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Length(max = 80, message = "La longitud no puede superara los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
