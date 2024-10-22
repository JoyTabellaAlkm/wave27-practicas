package com.mercadoLibre.HQL.controller;

import com.mercadoLibre.HQL.service.actors.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private IActorsService actorsService;

    @GetMapping("/with-favorite-movie")
    public ResponseEntity<?> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorsService.findActorsWithNotNullFavoriteMovie());
    }

    @GetMapping("/above-rating/{rating}")
    public ResponseEntity<?> getActorsAboveRating(@PathVariable Double rating) {
        return ResponseEntity.ok(actorsService.findActorsOverRating(rating));
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getMovieActors(@RequestParam(value = "movie") String movie) {
        return ResponseEntity.ok(actorsService.findActorsByMovieTitle(movie));
    }
}
