package com.example.calculatecalorias.services;

import com.example.calculatecalorias.dto.DishDto;
import com.example.calculatecalorias.dto.DishIngredentsDtoResponse;

import java.util.List;

public interface IDishServices {
    DishIngredentsDtoResponse calculateCalories(DishDto dishDto);
    List<DishIngredentsDtoResponse> calculateAllCalories(List<DishDto> dishDtos);
}
