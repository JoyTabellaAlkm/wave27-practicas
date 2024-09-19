package ar.com.mercadolibre.food.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientRequestDTO {
    private String name;
    private Integer grams;
}
