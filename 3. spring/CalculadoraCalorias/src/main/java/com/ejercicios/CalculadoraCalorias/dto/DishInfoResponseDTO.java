package com.ejercicios.CalculadoraCalorias.dto;

import com.ejercicios.CalculadoraCalorias.entity.Dish;
import com.ejercicios.CalculadoraCalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishInfoResponseDTO {
    Dish dish;
    Double totalCalories;
    Ingredient mostCaloric;
}
