package ar.com.mercadolibre.calorias.service;

import ar.com.mercadolibre.calorias.dto.FullMealDto;
import ar.com.mercadolibre.calorias.dto.FullMealRequestDto;
import ar.com.mercadolibre.calorias.dto.IngredientDto;
import ar.com.mercadolibre.calorias.dto.MealDto;

import java.util.List;

public interface MealService {
    Double getCaloriesByName(String name, Double weightInGrams);
    void createMeals();
    MealDto getMeal(String name);
    IngredientDto getMostCaloricIngredient(String name);
    List<FullMealDto> getFullMeals(List<FullMealRequestDto> request);
}
