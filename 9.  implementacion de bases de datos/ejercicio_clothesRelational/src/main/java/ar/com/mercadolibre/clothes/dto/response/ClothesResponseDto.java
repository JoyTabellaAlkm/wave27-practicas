package ar.com.mercadolibre.clothes.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothesResponseDto {
    private String name;
    private String type;
    private String brand;
    private String color;
    private Double size;
    private Integer quantity;
    @JsonProperty("selling_price")
    private Double sellingPrice;

}
