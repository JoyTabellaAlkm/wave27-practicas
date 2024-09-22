package ar.com.mercadolibre.calculadoracalorias.dto;

import ar.com.mercadolibre.calculadoracalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PlateDTO {
    private Integer totalCalories;
    private List<Ingredient> ingredients;
    private Ingredient biggestIngredient;
}
