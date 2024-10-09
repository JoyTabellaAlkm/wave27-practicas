package org.mercadolibre.calculadoracalorias.controller;

import org.mercadolibre.calculadoracalorias.dto.DishDTO;
import org.mercadolibre.calculadoracalorias.entity.Dish;
import org.mercadolibre.calculadoracalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DishController {
    @Autowired
    IDishService iDishService;

    @GetMapping("/get/{name}/{weight}")
    public ResponseEntity<?> getAllCalories(@PathVariable String name, @PathVariable double weight){
        try {
            return new ResponseEntity<>(
                    iDishService.getAllCalories(name, weight),
                    HttpStatus.OK
            );
        } catch (IOException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<?> getIngredientsList(@PathVariable String name){
        try {
            return new ResponseEntity<>(
                    iDishService.getIngredientsList(name),
                    HttpStatus.OK
            );
        } catch (IOException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/get/max/{name}")
    public ResponseEntity<?> getIngredientWithCalories(@PathVariable String name){
        try {
            return new ResponseEntity<>(
                    iDishService.getIngredientWithCalories(name),
                    HttpStatus.OK
            );
        } catch (IOException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/get/dishes")
    public ResponseEntity<?> getDishesByBody(@RequestBody List<DishDTO> dishList){
        try{
            return new ResponseEntity<>(
                    iDishService.getBonus(dishList),
                    HttpStatus.OK
            );
        }catch(Exception e){
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
