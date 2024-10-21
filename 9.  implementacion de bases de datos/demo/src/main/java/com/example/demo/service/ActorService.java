package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements IActorService{


    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public Optional<Actor> getActorById(Integer id) {
        return actorRepository.findById(Long.valueOf(id));
    }

    public List<Actor> getAll(){
        return actorRepository.findAll();
    }

    public Actor findActorByName(String name){
        return actorRepository.getFirstByFirstName(name);
    }

}

