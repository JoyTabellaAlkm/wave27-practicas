package co.mercadolibre.calorias.controller;

import co.mercadolibre.calorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    IFoodService iFoodService;

    @GetMapping("/consult/{name}")
    public ResponseEntity<?> getCaloriesConsult(@PathVariable String name){
        return new ResponseEntity<>(iFoodService.getCaloriesByPreparation(name), HttpStatus.OK) ;
    }
}
