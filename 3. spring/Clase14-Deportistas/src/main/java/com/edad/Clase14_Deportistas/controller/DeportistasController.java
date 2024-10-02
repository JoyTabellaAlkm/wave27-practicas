package com.edad.Clase14_Deportistas.controller;

import com.edad.Clase14_Deportistas.service.IDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportistasController {
    @Autowired
    IDeportistasService deportistasService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        return new ResponseEntity<>(deportistasService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(deportistasService.findSportByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportPeople(){
        return new ResponseEntity<>(deportistasService.findSportPeople(), HttpStatus.OK);
    }
}
