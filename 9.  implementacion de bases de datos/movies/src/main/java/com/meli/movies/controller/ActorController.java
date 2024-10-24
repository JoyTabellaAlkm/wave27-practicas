package com.meli.movies.controller;

import com.meli.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/listActorsWithFavoriteMovie")
    public ResponseEntity<?> listActorsWithFavoriteMovie(){
        return new ResponseEntity<>(actorService.listActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/listActorsByRating/{rating}")
    public ResponseEntity<?> listActorsByRating(@PathVariable Double rating){
        return new ResponseEntity<>(actorService.listActorsByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/listActorsByMovie/{movieName}")
    public ResponseEntity<?> listActorsByMovie(@PathVariable String movieName){
        return new ResponseEntity<>(actorService.listActorsByMovie(movieName), HttpStatus.OK);
    }

}
