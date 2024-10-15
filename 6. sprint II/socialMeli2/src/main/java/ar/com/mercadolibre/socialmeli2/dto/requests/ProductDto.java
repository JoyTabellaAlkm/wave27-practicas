package ar.com.mercadolibre.socialmeli2.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    @JsonProperty("product_id")
    private Integer id;

    @Pattern(regexp = "^(|[A-Za-záéíóúÁÉÍÓÚÑñ0-9\\s]+)$", message = "El campo no puede poseer caracteres especiales.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @JsonProperty("product_name")
    private String name;

    @Pattern(regexp = "^(|[A-Za-záéíóúÁÉÍÓÚÑñ0-9\\s]+)$", message = "El campo no puede poseer caracteres especiales.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String type;

    @Pattern(regexp = "^(|[A-Za-záéíóúÁÉÍÓÚÑñ0-9\\s]+)$", message = "El campo no puede poseer caracteres especiales.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    private String brand;

    @Pattern(regexp = "^(|[A-Za-záéíóúÁÉÍÓÚÑñ0-9\\s]+)$", message = "El campo no puede poseer caracteres especiales.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String color;

    @Pattern(regexp = "^(|[A-Za-záéíóúÁÉÍÓÚÑñ0-9\\s]+)$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    private String notes;
}