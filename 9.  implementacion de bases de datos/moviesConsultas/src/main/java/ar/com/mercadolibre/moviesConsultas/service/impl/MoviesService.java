package ar.com.mercadolibre.moviesConsultas.service.impl;

import ar.com.mercadolibre.moviesConsultas.model.Movie;
import ar.com.mercadolibre.moviesConsultas.model.dto.response.MovieResponseDTO;
import ar.com.mercadolibre.moviesConsultas.repository.MovieRepository;
import ar.com.mercadolibre.moviesConsultas.service.IMoviesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MoviesService implements IMoviesService {

    private final MovieRepository repository;
    private final ModelMapper modelMapper;

    public List<MovieResponseDTO> getMovieByActorRating(Double rating){
        return repository.getMovieByActorRating(rating).stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<MovieResponseDTO> getMoviebyGenreId(Integer genre){
        return repository.getMovieByGenreId(genre).stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDTO.class))
                .collect(Collectors.toList());
    }
}
