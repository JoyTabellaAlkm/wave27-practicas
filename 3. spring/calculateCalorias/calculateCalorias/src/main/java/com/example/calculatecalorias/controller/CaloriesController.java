package com.example.calculatecalorias.controller;

import com.example.calculatecalorias.dto.DishDto;
import com.example.calculatecalorias.services.IDishServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CaloriesController {

    private final IDishServices platoServices;

    public CaloriesController(IDishServices platoServices) {
        this.platoServices = platoServices;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> calculate(@RequestBody DishDto dishDto){
        return new ResponseEntity<>(platoServices.calculateCalories(dishDto), HttpStatus.OK);
    }
    @PostMapping("/calculatarTodos")
    public ResponseEntity<?> calculateAllCalories(@RequestBody List<DishDto> dishDtos){
        return new ResponseEntity<>(platoServices.calculateAllCalories(dishDtos), HttpStatus.OK);
    }
}
