package co.mercadolibre.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonProperty("product_id")
    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 1, message = "El id del producto debe ser mayor a cero") //probar que no reciba otra cosa que no sea int
    private Integer productId;


    @JsonProperty("product_name")
    @NotBlank(message = "El campo no puede estar vacío.") //probar esto
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;


    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;


    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;


    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
