package com.meli.movies.service;

import com.meli.movies.dto.ActorDto;

import java.util.List;

public interface IActorService {
    List<ActorDto> listActorsWithFavoriteMovie();
    List<ActorDto> listActorsByRating(Double rating);
    List<ActorDto> listActorsByMovie(String movieName);
}
