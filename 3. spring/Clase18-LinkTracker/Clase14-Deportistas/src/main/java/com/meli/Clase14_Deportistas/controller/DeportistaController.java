package com.meli.Clase14_Deportistas.controller;

import com.meli.Clase14_Deportistas.service.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportistaController {
    @Autowired
    IDeportistaService deportistaService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findAllSports(){
        return new ResponseEntity<>(deportistaService.findAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name){
        return new ResponseEntity<>(deportistaService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        return new ResponseEntity<>(deportistaService.findSportsPeople(), HttpStatus.OK);
    }
}
