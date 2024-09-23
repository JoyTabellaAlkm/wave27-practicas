package ar.com.mercadolibre.ejercicioStarWars.controller;

import ar.com.mercadolibre.ejercicioStarWars.entity.Personaje;
import ar.com.mercadolibre.ejercicioStarWars.repository.StarWarsRepository;
import ar.com.mercadolibre.ejercicioStarWars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    private final IService iService;
    private final StarWarsRepository starWarsRepository;

    @Autowired
    public StarWarsController(IService iService, StarWarsRepository starWarsRepository){
        this.iService = iService;
        this.starWarsRepository = starWarsRepository;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajeName(@PathVariable String name){
        return new ResponseEntity<>(iService.getPersonajeName(name), HttpStatus.OK);
    }
}
