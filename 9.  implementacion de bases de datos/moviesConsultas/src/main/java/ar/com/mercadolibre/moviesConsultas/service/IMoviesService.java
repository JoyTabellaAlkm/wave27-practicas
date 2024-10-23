package ar.com.mercadolibre.moviesConsultas.service;

import ar.com.mercadolibre.moviesConsultas.model.dto.response.MovieResponseDTO;

import java.util.List;

public interface IMoviesService {
    List<MovieResponseDTO> getMovieByActorRating(Double rating);
    List<MovieResponseDTO> getMoviebyGenreId(Integer genre);
}
