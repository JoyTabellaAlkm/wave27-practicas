package ar.com.mercadolibre.calorias.dto;

import java.util.List;

public record MealDto(
        String name,
        List<IngredientDto> ingredients
) { }
