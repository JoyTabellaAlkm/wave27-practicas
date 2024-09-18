package com.mercadolibre.deportista.controller;

import com.mercadolibre.deportista.model.Deporte;
import com.mercadolibre.deportista.service.IDeportistaFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class DeportistaRestController {

    @Autowired
    IDeportistaFinder deportistaFinder;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getSports(){
        //if( deportistaFinder.getDeportistas() ==null){
        // return new ResponseEntity<>("La lista consultada está vacía",HttpStatus.OK);
        //}
        return new ResponseEntity<>( deportistaFinder.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<?> getSportByName(@PathVariable String name){
        if(deportistaFinder.checkDeporte(name)==null){
            return new ResponseEntity<>("El deportista no existe",HttpStatus.OK);
        }
        return new ResponseEntity<>(deportistaFinder.checkDeporte(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<?>getSportsPersons(){
        if (deportistaFinder.getDeportistas().isEmpty()){
            return new ResponseEntity<>("No hay personas deportistas", HttpStatus.OK);

        }
        return new ResponseEntity<>(deportistaFinder.getDeportistas(),HttpStatus.OK);
    }
}
