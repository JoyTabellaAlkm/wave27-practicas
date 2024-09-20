package com.ejercicios.CalculadoraCalorias.repository;

import com.ejercicios.CalculadoraCalorias.entity.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientsRepository {

    @Autowired
    public final ObjectMapper JSON_MAPPER = new ObjectMapper();
    List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getAllingredients(){
        try {
            ingredients =JSON_MAPPER.readValue(new File("src/main/resources/ingredients.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Ingredient.class));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ingredients;
    }

    public Ingredient getIngredientByName(String name){
        return ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst().get();
    }
}
