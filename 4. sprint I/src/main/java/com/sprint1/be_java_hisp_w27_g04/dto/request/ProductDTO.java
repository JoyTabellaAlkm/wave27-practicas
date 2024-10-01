package com.sprint1.be_java_hisp_w27_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotNull
    @JsonProperty("product_id")
    private Integer id;
    @NotBlank
    @JsonProperty("product_name")
    private String productName;
    @NotBlank
    private String type;
    @NotBlank
    private String brand;
    @NotBlank
    private String color;
    @NotBlank
    private String notes;

}