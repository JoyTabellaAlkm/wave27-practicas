package ar.com.mercadolibre.food.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IngredientResponseDTO {
    private String name;
    private Double calories;
}
