package com.ejercicios.CalculadoraCalorias.service.impl;

import com.ejercicios.CalculadoraCalorias.dto.DishInfoResponseDTO;
import com.ejercicios.CalculadoraCalorias.entity.Dish;
import com.ejercicios.CalculadoraCalorias.entity.Ingredient;
import com.ejercicios.CalculadoraCalorias.repository.DishesRepository;
import com.ejercicios.CalculadoraCalorias.service.ICalcularCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class CalcularCaloriasServiceImpl implements ICalcularCaloriasService {

    @Autowired
    DishesRepository dishesRepository;

    @Override
    public DishInfoResponseDTO getDishInfoByName(String name) {
        Dish dish = dishesRepository.getDishByName(name);
        Double calories = dish.getIngredients().stream().mapToDouble(Ingredient::getCalories).sum();
        Ingredient mostCaloric = dish.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).get();
        DishInfoResponseDTO dto = new DishInfoResponseDTO();
        dto.setDish(dish);
        dto.setMostCaloric(mostCaloric);
        dto.setTotalCalories(calories);
        return dto;
    }
}
