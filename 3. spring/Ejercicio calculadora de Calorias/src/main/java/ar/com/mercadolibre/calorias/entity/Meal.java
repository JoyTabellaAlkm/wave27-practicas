package ar.com.mercadolibre.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Meal {
    private String name;
    private List<Ingredient> ingredients;

    public Double getCalories(Double weightInGrams) {
        return ingredients.stream()
                .mapToDouble(i -> (i.getCalories() / 100.0) * weightInGrams / ingredients.size())
                .sum();
    }
}
