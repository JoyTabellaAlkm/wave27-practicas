package ar.com.mercadolibre.calorias.repository.impl;

import ar.com.mercadolibre.calorias.entity.Meal;
import ar.com.mercadolibre.calorias.repository.MealRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MealRepositoryImpl implements MealRepository {
    private List<Meal> meals;

    public MealRepositoryImpl() {
        this.meals = new ArrayList<>();
    }

    public void save(Meal meal) {
        meals.add(meal);
    }

    public Optional<Meal> getByName(String name) {
        return meals.stream()
                .filter(meal -> meal.getName().equals(name))
                .findFirst();
    }

    public List<Meal> getByNames(List<String> names) {
        return meals.stream()
                .filter(meal -> names.contains(meal.getName()))
                .toList();
    }
}
