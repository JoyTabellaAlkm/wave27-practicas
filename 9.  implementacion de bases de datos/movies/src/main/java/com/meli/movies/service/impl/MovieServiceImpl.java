package com.meli.movies.service.impl;

import com.meli.movies.dto.MovieDto;
import com.meli.movies.repository.IMovieRepository;
import com.meli.movies.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    private final IMovieRepository movieRepository;
    private ModelMapper mapper = new ModelMapper();

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> movieActorsByRating(Double rating) {
        return movieRepository.movieActorsByRating(rating).stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .toList();
    }

    @Override
    public List<MovieDto> moviesByGenre(String genreName) {
        return movieRepository.moviesByGenre(genreName).stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .toList();
    }
}
