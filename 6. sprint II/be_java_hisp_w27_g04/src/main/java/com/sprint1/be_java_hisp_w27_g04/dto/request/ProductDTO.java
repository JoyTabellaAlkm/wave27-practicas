package com.sprint1.be_java_hisp_w27_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @JsonProperty("product_id")
    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer id;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 40 caracteres", max = 40)
    @Pattern(message = "El campo no puede poseer caracteres especiales",
            regexp = "^[a-zA-Z0-9 ]*$")
    @JsonProperty("product_name")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los quince caracteres", max = 15)
    @Pattern(message = "El campo no puede poseer caracteres especiales",
            regexp = "^[a-zA-Z0-9 ]*$")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los quince caracteres", max = 25)
    @Pattern(message = "El campo no puede poseer caracteres especiales",
            regexp = "^[a-zA-Z0-9 ]*$")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los quince caracteres", max = 15)
    @Pattern(message = "El campo no puede poseer caracteres especiales",
            regexp = "^[a-zA-Z0-9 ]*$")
    private String color;

    @Size(message = "La longitud no puede superar los quince caracteres", max = 80)
    @Pattern(message = "El campo no puede poseer caracteres especiales",
            regexp = "^[a-zA-Z0-9 ]*$")
    private String notes;

}