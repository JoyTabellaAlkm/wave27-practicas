package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.MovieCharacterDTO;
import com.mercadolibre.starwars.service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieCharacterController {

    @Autowired
    MovieCharacterService movieCharacterService;

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<MovieCharacterDTO> movieCharacterDTOList = movieCharacterService.findByName(name);

        return ResponseEntity.ok().body(movieCharacterDTOList);
    }
}
