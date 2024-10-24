package ar.com.mercadolibre.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClothesRequestSaleDto {
    @NotBlank(message = "El id no puede estar vacío")
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String type;

    @NotBlank(message = "La marca no puede estar vacía")
    private String brand;

    @NotBlank(message = "El color no puede estar vacío")
    private String color;

    @Positive(message = "El tamaño debe ser un número positivo")
    private Double size;

    @PositiveOrZero(message = "La cantidad debe ser cero o un número positivo")
    private Integer quantity;

    @Positive(message = "El precio de venta debe ser un número positivo")
    @JsonProperty("selling_price")
    private Double sellingPrice;

}
