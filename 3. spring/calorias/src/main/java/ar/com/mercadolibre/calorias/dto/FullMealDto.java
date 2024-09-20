package ar.com.mercadolibre.calorias.dto;

import java.util.List;

public record FullMealDto(
        String name,
        Double calories,
        List<IngredientDto> ingredients,
        IngredientDto mostCaloricIngredient
) { }
