package com.example.calculatecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishIngredentsDtoResponse {

    private String dishName;
    private double totalCalories;
    private IngredientsDto highestCalorieIngredient;
    private List<IngredientsDto> ingredients;


}
