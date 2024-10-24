package com.meli.movies.service.impl;

import com.meli.movies.dto.ActorDto;
import com.meli.movies.repository.IActorRepository;
import com.meli.movies.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {
    private final IActorRepository actorRepository;
    private ModelMapper mapper = new ModelMapper();

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDto> listActorsWithFavoriteMovie() {
        return actorRepository.findActorsByFavoriteMovieIdIsNotNull().stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> listActorsByRating(Double rating) {
        return actorRepository.findActorsByRatingGreaterThan(rating).stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> listActorsByMovie(String movieName) {
        return actorRepository.findActorsByMovie(movieName).stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();

    }
}
