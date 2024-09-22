package ar.com.mercadolibre.calculadoracalorias.repository;

import ar.com.mercadolibre.calculadoracalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientsRepository {
    private List<Ingredient> ingredients;
    private ObjectMapper objectMapper = new ObjectMapper();

    public IngredientsRepository() {
        ingredients = new ArrayList<>();
        this.ingredients = fillIngredients();
    }

    private List<Ingredient> fillIngredients() {
        try {
            return objectMapper.readValue(
                    new File("src/main/resources/food.json"),
                    new TypeReference<>() {
                    }
            );

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Ingredient> findAll() {
        return ingredients;
    }
}
