package ar.com.mercadolibre.food.model.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DishRequestDTO {
    private String name;
    private List<IngredientRequestDTO> dish;
}
