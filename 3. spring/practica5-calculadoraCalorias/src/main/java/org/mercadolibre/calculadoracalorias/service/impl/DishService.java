package org.mercadolibre.calculadoracalorias.service.impl;

import org.mercadolibre.calculadoracalorias.dto.DishDTO;
import org.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import org.mercadolibre.calculadoracalorias.entity.Dish;
import org.mercadolibre.calculadoracalorias.entity.Ingredients;
import org.mercadolibre.calculadoracalorias.repository.impl.DishRepositoryImpl;
import org.mercadolibre.calculadoracalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {

    @Autowired
    DishRepositoryImpl dishRepository;

    private List<DishDTO> formatDishDTO() {
        List<Dish> dishes = dishRepository.leerArchivo();
        List <DishDTO> dishesDTO = new ArrayList<>();

        dishes.stream().forEach(p -> {
            DishDTO dishAux = new DishDTO(p.getName(), p.getWeight(), p.getIngredients());
            dishesDTO.add(dishAux);
        });
        return dishesDTO;
    }


    private DishDTO getDishByName(String name) throws IOException {
        return formatDishDTO().stream().filter(dishDTO -> dishDTO.getName().equals(name)).toList().getFirst();
    }

    @Override
    public Double getAllCalories(String name, double weight) throws IOException {
        DishDTO dish = getDishByName(name);

        if (dish == null){
            throw new RuntimeException("Plato no existe");
        }

        Double caloriasTotales = dish.getIngredients().stream().mapToDouble(i -> i.getCalories() * dish.getWeight()).sum();

        return caloriasTotales;

    }

    @Override
    public List<Ingredients> getIngredientsList(String name) throws IOException {
        DishDTO dish = getDishByName(name);

        if (dish == null){
            throw new RuntimeException("Plato no existe");
        }

        return dish.getIngredients();
    }

    @Override
    public String getIngredientWithCalories(String name) throws IOException {
        DishDTO dishDTO = getDishByName(name);

        if (dishDTO != null){
            Ingredients ingredients = dishDTO.getIngredients().stream().reduce((a, b) -> {
                return a.getCalories() > b.getCalories() ? a : b;
            }).orElse(null);

            if (ingredients == null) throw new RuntimeException("Plato sin ingredientes");

            return ingredients.toString();
        }
        return "Plato no encontrado";
    }

    @Override
    public Ingredients getIngredientWithMaxCalories(String name) throws IOException {
        DishDTO dish = getDishByName(name);
        if (dish == null){
            throw new RuntimeException("Plato no existe");
        }
        Optional<Ingredients> maxCaloria = dish.getIngredients().stream().max(Comparator.comparing(Ingredients::getCalories));

        return maxCaloria.get();
    }

    @Override
    public List<DishResponseDTO> getBonus(List<DishDTO> dishList){
        return dishList.stream().map(dishDTO -> {
            try {
                Double calories = getAllCalories(dishDTO.getName(), dishDTO.getWeight());
                List<Ingredients> ingredientsList = getIngredientsList(dishDTO.getName());
                Ingredients max = getIngredientWithMaxCalories(dishDTO.getName());
                return new DishResponseDTO(
                        dishDTO.getName(),
                        ingredientsList,
                        calories,
                        max
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
