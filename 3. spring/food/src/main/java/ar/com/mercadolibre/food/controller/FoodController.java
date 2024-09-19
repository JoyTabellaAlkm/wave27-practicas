package ar.com.mercadolibre.food.controller;

import ar.com.mercadolibre.food.model.dto.request.DishRequestDTO;
import ar.com.mercadolibre.food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @GetMapping()
    public ResponseEntity<?> getDishResponse(@RequestBody DishRequestDTO dishRequestDTO){

        return  ResponseEntity.ok(foodService.calculateCalories(dishRequestDTO));

    }

    @GetMapping("/list")
    public ResponseEntity<?> getDishListResponse(@RequestBody List<DishRequestDTO> dishRequestDTO){

        return  ResponseEntity.ok(foodService.calculateCaloriesList(dishRequestDTO));

    }

}
