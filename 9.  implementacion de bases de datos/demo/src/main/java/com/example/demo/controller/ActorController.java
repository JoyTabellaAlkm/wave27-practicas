package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import com.example.demo.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final IActorService service;

    public ActorController(ActorService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Actor>> getAllActors(){
        List<Actor> response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Actor>> getById(@PathVariable Integer id){
        Optional<Actor> response = service.getActorById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Actor> getById(@PathVariable String name){
        Actor response = service.findActorByName(name);
        return ResponseEntity.ok(response);
    }

}
