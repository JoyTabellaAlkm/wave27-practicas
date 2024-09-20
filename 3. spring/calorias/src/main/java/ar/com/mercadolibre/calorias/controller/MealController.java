package ar.com.mercadolibre.calorias.controller;

import ar.com.mercadolibre.calorias.dto.FullMealDto;
import ar.com.mercadolibre.calorias.dto.FullMealRequestDto;
import ar.com.mercadolibre.calorias.dto.IngredientDto;
import ar.com.mercadolibre.calorias.dto.MealDto;
import ar.com.mercadolibre.calorias.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/{name}/calories")
    public ResponseEntity<?> getCaloriesByName(@PathVariable String name, @RequestParam Double weightInGrams) {
        Double calories = mealService.getCaloriesByName(name, weightInGrams);
        return calories != null
                ? ResponseEntity.ok(calories)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        MealDto meal = mealService.getMeal(name);
        return meal != null
                ? ResponseEntity.ok(meal)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}/mostCaloric")
    public ResponseEntity<?> getMostCaloricIngredient(@PathVariable String name) {
        IngredientDto ingredient = mealService.getMostCaloricIngredient(name);
        return ingredient != null
                ? ResponseEntity.ok(ingredient)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> getFullMeals(@RequestBody List<FullMealRequestDto> request) {
        List<FullMealDto> meals = mealService.getFullMeals(request);
        return meals != null
                ? ResponseEntity.ok(meals)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createMeals() {
        mealService.createMeals();
        return ResponseEntity.noContent().build();
    }
}
