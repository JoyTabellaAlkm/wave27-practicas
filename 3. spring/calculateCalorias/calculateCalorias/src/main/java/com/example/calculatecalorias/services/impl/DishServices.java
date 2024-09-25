package com.example.calculatecalorias.services.impl;

import com.example.calculatecalorias.dto.IngredientsDto;
import com.example.calculatecalorias.dto.DishDto;
import com.example.calculatecalorias.dto.DishIngredentsDtoResponse;
import com.example.calculatecalorias.repository.IDishRepository;
import com.example.calculatecalorias.services.IDishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServices implements IDishServices {

    @Autowired
    private IDishRepository platoRepository;

    @Override
    public DishIngredentsDtoResponse calculateCalories(DishDto dishDto) {
        double totalCalories = 0;
        IngredientsDto highestCalorieIngredient = null;
        List<IngredientsDto> dishIngredients = new ArrayList<>();

        for (IngredientsDto ingredient : platoRepository.getIngredients()) {
            IngredientsDto ingredientInDish = platoRepository.findIngredientByName(ingredient.getName());

            if (ingredientInDish != null) {
                double ingredientCalories = (ingredientInDish.getCalories() * dishDto.getPeso()) / 100.0;
                ingredientInDish.setCalories((int) ingredientCalories);
                dishIngredients.add(ingredientInDish);
                totalCalories += ingredientCalories;

                if (highestCalorieIngredient == null || ingredientCalories > highestCalorieIngredient.getCalories()) {
                    highestCalorieIngredient = ingredientInDish;
                }
            }
        }

        DishIngredentsDtoResponse response = new DishIngredentsDtoResponse();
        response.setDishName(dishDto.getName());
        response.setTotalCalories(totalCalories);
        response.setIngredients(dishIngredients);
        response.setHighestCalorieIngredient(highestCalorieIngredient);

        return response;
    }

    @Override
    public List<DishIngredentsDtoResponse> calculateAllCalories(List<DishDto> dishDtos) {

        List<DishIngredentsDtoResponse> dishIngredentsDtoResponseArrayList = new ArrayList<>();
        for (DishDto dishDto : dishDtos) {
            dishIngredentsDtoResponseArrayList.add(this.calculateCalories(dishDto));
        }
        return dishIngredentsDtoResponseArrayList;
    }
}

