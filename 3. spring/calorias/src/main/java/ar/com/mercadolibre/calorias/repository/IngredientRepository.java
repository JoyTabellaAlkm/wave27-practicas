package ar.com.mercadolibre.calorias.repository;

import ar.com.mercadolibre.calorias.entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Optional<Ingredient> getByName(String name);
}
