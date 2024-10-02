package com.meli.clase16calorias.controller;

import com.meli.clase16calorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MenuController {
    @Autowired
    IMenuService menuService;

    @GetMapping("/menu")
    public ResponseEntity<?> showMenu(){
        return new ResponseEntity<>(menuService.showMenu(), HttpStatus.OK);
    }

    @GetMapping("/menu/{nombre}/{peso}")
    public ResponseEntity<?> showMenuByNameAndWeight(@PathVariable String nombre, @PathVariable int peso){
        return new ResponseEntity<>(menuService.showPlateByWeight(nombre, peso), HttpStatus.OK);
    }
}
