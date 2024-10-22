package com.mercadoLibre.HQL.service.actors;

import com.mercadoLibre.HQL.dto.ActorResponseDTO;
import com.mercadoLibre.HQL.entity.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorsService{
    List<ActorResponseDTO> findActorsWithNotNullFavoriteMovie();
    List<ActorResponseDTO> findActorsOverRating(Double rating);
    List<ActorResponseDTO> findActorsByMovieTitle(String title);
}
