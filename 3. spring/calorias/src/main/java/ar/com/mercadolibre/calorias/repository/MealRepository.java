package ar.com.mercadolibre.calorias.repository;

import ar.com.mercadolibre.calorias.entity.Meal;

import java.util.List;
import java.util.Optional;

public interface MealRepository {
    void save(Meal meal);
    Optional<Meal> getByName(String name);
    List<Meal> getByNames(List<String> names);
}
