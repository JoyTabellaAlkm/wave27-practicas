package com.example.demo.service;

import com.example.demo.model.Actor;

import java.util.List;
import java.util.Optional;

public interface IActorService {

    Optional<Actor> getActorById(Integer id);

    List<Actor> getAll();

    Actor findActorByName(String name);
}
