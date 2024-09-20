package ar.com.mercadolibre.calorias.service.impl;

import ar.com.mercadolibre.calorias.dto.FullMealDto;
import ar.com.mercadolibre.calorias.dto.FullMealRequestDto;
import ar.com.mercadolibre.calorias.dto.IngredientDto;
import ar.com.mercadolibre.calorias.dto.MealDto;
import ar.com.mercadolibre.calorias.entity.Ingredient;
import ar.com.mercadolibre.calorias.entity.Meal;
import ar.com.mercadolibre.calorias.repository.IngredientRepository;
import ar.com.mercadolibre.calorias.repository.MealRepository;
import ar.com.mercadolibre.calorias.service.MealService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {
    private MealRepository mealRepository;
    private IngredientRepository ingredientRepository;

    public MealServiceImpl(MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Double getCaloriesByName(String name, Double weightInGrams) {
        Optional<Meal> meal = mealRepository.getByName(name);
        return meal.map(value -> value.getCalories(weightInGrams)).orElse(null);
    }

    public MealDto getMeal(String name) {
        Optional<Meal> mealOptional = mealRepository.getByName(name);

        if (mealOptional.isPresent()) {
            Meal meal = mealOptional.get();

            return new MealDto(
                    meal.getName(),
                    meal.getIngredients().stream()
                            .map(i -> new IngredientDto(i.getName(), i.getCalories()))
                            .toList()
            );
        }

        return null;
    }

    public IngredientDto getMostCaloricIngredient(String name) {
        Optional<Meal> mealOptional = mealRepository.getByName(name);

        if (mealOptional.isEmpty() || mealOptional.get().getIngredients().isEmpty()) {
            return null;
        }

        Ingredient mostCaloricIngredient = mealOptional.get().getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .get();

        return new IngredientDto(mostCaloricIngredient.getName(), mostCaloricIngredient.getCalories());
    }

    public List<FullMealDto> getFullMeals(List<FullMealRequestDto> request) {
        try {

            return request.stream()
                .map(r -> {
                    Meal meal = mealRepository.getByName(r.name()).orElseThrow();
                    Double calories = meal.getCalories(r.weightInGrams());
                    List<IngredientDto> ingredients = meal.getIngredients().stream()
                            .map(i -> new IngredientDto(i.getName(), i.getCalories()))
                            .toList();
                    IngredientDto mostCaloric = getMostCaloricIngredient(r.name());

                    return new FullMealDto(r.name(), calories, ingredients, mostCaloric);
                }).toList();
        } catch (Exception ex)  {
            return null;
        }
    }

    public void createMeals() {
        Ingredient acelga = ingredientRepository.getByName("Acelgas").orElseThrow();
        Ingredient ajo = ingredientRepository.getByName("Ajos").orElseThrow();
        Ingredient alcachofa = ingredientRepository.getByName("Alcachofas").orElseThrow();
        Ingredient cebolla = ingredientRepository.getByName("Cebolla").orElseThrow();
        Ingredient kiwi = ingredientRepository.getByName("Kiwi").orElseThrow();
        Ingredient higos = ingredientRepository.getByName("Higos").orElseThrow();

        Meal meal1 = new Meal(
            "plato1",
                List.of(acelga, ajo));

        Meal meal2 = new Meal(
                "plato2",
                List.of(acelga, alcachofa, cebolla));

        Meal meal3 = new Meal(
                "plato3",
                List.of(ajo, kiwi, higos));

        mealRepository.save(meal1);
        mealRepository.save(meal2);
        mealRepository.save(meal3);
    }
}
