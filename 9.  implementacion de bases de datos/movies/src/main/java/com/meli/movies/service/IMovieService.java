package com.meli.movies.service;

import com.meli.movies.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> movieActorsByRating(Double rating);
    List<MovieDto> moviesByGenre(String genreName);
}
