package ar.com.mercadolibre.moviesConsultas.service;

import ar.com.mercadolibre.moviesConsultas.model.dto.response.ActorResponseDTO;

import java.util.List;

public interface IActorService {
    List<ActorResponseDTO> findByFavoriteMovie();
    List<ActorResponseDTO> getByRating(Double rating);
    List<ActorResponseDTO> getByMovie(String title);
}
