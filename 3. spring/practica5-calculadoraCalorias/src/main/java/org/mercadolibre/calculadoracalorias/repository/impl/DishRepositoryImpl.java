package org.mercadolibre.calculadoracalorias.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.calculadoracalorias.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepositoryImpl {
    @Autowired
    public final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private ArrayList<Dish> dishes = new ArrayList<>();

    public List<Dish> leerArchivo() {
        try {
            File file = new File("src/main/resources/data/dish.json");
            dishes = JSON_MAPPER.readValue(file,JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Dish.class));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
