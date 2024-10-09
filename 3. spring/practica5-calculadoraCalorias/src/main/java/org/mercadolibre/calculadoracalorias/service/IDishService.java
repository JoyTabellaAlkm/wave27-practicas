package org.mercadolibre.calculadoracalorias.service;

import org.mercadolibre.calculadoracalorias.dto.DishDTO;
import org.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import org.mercadolibre.calculadoracalorias.entity.Dish;
import org.mercadolibre.calculadoracalorias.entity.Ingredients;

import java.io.IOException;
import java.util.List;

public interface IDishService {
    Double getAllCalories(String name, double weight) throws IOException;

    List<Ingredients> getIngredientsList(String name) throws IOException;

    String getIngredientWithCalories(String name) throws IOException;

    Ingredients getIngredientWithMaxCalories(String name) throws IOException;

    List<DishResponseDTO> getBonus(List<DishDTO> dishList);
}
