package com.meli.movies.controller;

import com.meli.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/movieActorsByRating/{rating}")
    public ResponseEntity<?> movieActorsByRating(@PathVariable Double rating){
        return new ResponseEntity<>(movieService.movieActorsByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/moviesByGenre/{genreName}")
    public ResponseEntity<?> moviesByGenre(@PathVariable String genreName){
        return new ResponseEntity<>(movieService.moviesByGenre(genreName), HttpStatus.OK);
    }
}
