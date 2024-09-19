package ar.com.mercadolibre.food.service.impl;

import ar.com.mercadolibre.food.model.Food;
import ar.com.mercadolibre.food.model.dto.request.DishRequestDTO;
import ar.com.mercadolibre.food.model.dto.response.DishResponseDTO;
import ar.com.mercadolibre.food.model.dto.response.IngredientResponseDTO;
import ar.com.mercadolibre.food.repository.FoodRepository;
import ar.com.mercadolibre.food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService {

    @Autowired
    FoodRepository foodRepository;

    public DishResponseDTO calculateCalories(DishRequestDTO dish) {
        List<IngredientResponseDTO> foodList = dish.getDish().stream()
                .map(ingredient -> {
                    Food foodFromRepo = foodRepository.getFood(ingredient.getName());
                    double caloriesPerGram = Double.parseDouble(foodFromRepo.getCalories()) / 100;
                    double calculatedCalories = caloriesPerGram * ingredient.getGrams();
                    return new IngredientResponseDTO(ingredient.getName(), calculatedCalories);
                })
                .collect(Collectors.toList());

        Double totalCalories = getTotalCalories(foodList);

        IngredientResponseDTO maxCalorie = getHigherCalorieIngredient(foodList);

        return new DishResponseDTO(totalCalories, foodList, maxCalorie);
    }


    public Double getTotalCalories(List<IngredientResponseDTO> foodList){
        return foodList.stream()
                .mapToDouble(IngredientResponseDTO::getCalories)
                .sum();
    }

    public IngredientResponseDTO getHigherCalorieIngredient(List<IngredientResponseDTO> foodList){
        return foodList.stream()
                .max(Comparator.comparingDouble(IngredientResponseDTO::getCalories))
                .orElse(null);
    }


    public List<DishResponseDTO> calculateCaloriesList(List<DishRequestDTO> dish) {
        List<DishResponseDTO> responseList = new ArrayList<>();

        for(DishRequestDTO dishRequestDTO: dish){
            responseList.add(calculateCalories(dishRequestDTO));
        }

        return responseList;
    }
}
