package ar.com.mercadolibre.food.service;

import ar.com.mercadolibre.food.model.dto.request.DishRequestDTO;
import ar.com.mercadolibre.food.model.dto.response.DishResponseDTO;

import java.util.List;

public interface IFoodService {

    DishResponseDTO calculateCalories(DishRequestDTO dish);

    List<DishResponseDTO> calculateCaloriesList(List<DishRequestDTO> dish);

}
