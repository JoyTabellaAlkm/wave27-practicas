package ar.com.mercadolibre.food.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishResponseDTO {
    @JsonProperty("total-calories")
    private Double totalCalories;

    @JsonProperty("ingredient-list")
    private List<IngredientResponseDTO> ingredientList;

    @JsonProperty("max-calorie-ingredient")
    private IngredientResponseDTO maxCalorieIngredient;
}
