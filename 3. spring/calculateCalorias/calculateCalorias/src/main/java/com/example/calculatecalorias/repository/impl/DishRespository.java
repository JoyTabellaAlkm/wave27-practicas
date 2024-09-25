package com.example.calculatecalorias.repository.impl;

import com.example.calculatecalorias.dto.IngredientsDto;
import com.example.calculatecalorias.repository.IDishRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRespository implements IDishRepository {
    private List<IngredientsDto> ingredientes = new ArrayList<>();


    public DishRespository() throws IOException {
        try {
            loadIngredients();
        } catch (IOException e) {
            throw new RuntimeException("Error loading ingredients", e);
        }

    }


    private void loadIngredients() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<IngredientsDto> ingredientsDtoList;

        file = ResourceUtils.getFile("classpath:food.json");
        ingredientsDtoList = objectMapper.readValue(file, new TypeReference<List<IngredientsDto>>() {
        });

        ingredientes = ingredientsDtoList;
    }

   @Override
    public List<IngredientsDto> getIngredients() {
        return ingredientes;
    }
    public IngredientsDto findIngredientByName(String name) {
        return ingredientes.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
