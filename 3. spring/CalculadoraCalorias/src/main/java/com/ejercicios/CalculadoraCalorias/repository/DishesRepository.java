package com.ejercicios.CalculadoraCalorias.repository;

import com.ejercicios.CalculadoraCalorias.entity.Dish;
import com.ejercicios.CalculadoraCalorias.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishesRepository {
    @Autowired
    IngredientsRepository ingredientsRepository;

    List<Dish> dishes = new ArrayList<>();
    public void createDishes(){
        ingredientsRepository = new IngredientsRepository();
        ingredientsRepository.getAllingredients();
        Ingredient hamburguesa = ingredientsRepository.getIngredientByName("Hamburguesa");
        Ingredient cebolla = ingredientsRepository.getIngredientByName("Cebolla");
        Ingredient tomate = ingredientsRepository.getIngredientByName("Tomates");
        Ingredient pepino = ingredientsRepository.getIngredientByName("Pepino");
        Ingredient lechuga = ingredientsRepository.getIngredientByName("Lechuga");
        Ingredient quesoMozzarella = ingredientsRepository.getIngredientByName("Queso mozzarella");
        Ingredient mostaza = ingredientsRepository.getIngredientByName("Mostaza");
        Ingredient ketchup = ingredientsRepository.getIngredientByName("Ketchup");
        dishes.add(new Dish("Hamburguesa", List.of(hamburguesa, cebolla, pepino, lechuga, quesoMozzarella, mostaza, ketchup)));
        dishes.add(new Dish("Ensalada", List.of(lechuga, tomate, cebolla, pepino)));
        dishes.add(new Dish("Sopa de tomate", List.of(tomate, ketchup, cebolla)));
    }

    public Dish getDishByName(String name){
        createDishes();
        return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
    }
}
