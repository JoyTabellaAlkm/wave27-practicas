package ar.com.mercadolibre.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Plate {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Integer calories;
    private Integer weight;

    public Plate(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        calories = calculateCalories();
        weight = ingredients.size() * 100;
    }

    private int calculateCalories() {
        return ingredients.stream()
                .mapToInt(i -> i.getCalories())
                .sum();
    }
}
