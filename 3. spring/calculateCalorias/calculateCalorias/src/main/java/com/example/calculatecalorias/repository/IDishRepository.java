package com.example.calculatecalorias.repository;

import com.example.calculatecalorias.dto.IngredientsDto;


import java.util.List;

public interface IDishRepository {
    List<IngredientsDto> getIngredients();
    IngredientsDto findIngredientByName(String name);
}
