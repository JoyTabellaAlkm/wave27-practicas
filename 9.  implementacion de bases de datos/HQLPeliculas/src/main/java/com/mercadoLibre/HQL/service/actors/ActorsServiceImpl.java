package com.mercadoLibre.HQL.service.actors;

import com.mercadoLibre.HQL.dto.ActorResponseDTO;
import com.mercadoLibre.HQL.entity.Actors;
import com.mercadoLibre.HQL.repository.IActorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorsServiceImpl implements  IActorsService{

    @Autowired
    private IActorsRepository actorsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ActorResponseDTO> findActorsWithNotNullFavoriteMovie() {
        List<Actors> actorsList = actorsRepository.findActorsWithNotNullFavoriteMovie();
        List<ActorResponseDTO> actorResponseDTOList = new ArrayList<>();
        actorsList.forEach(actor -> {
            actorResponseDTOList.add(new ActorResponseDTO(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovie().getTitle()));
        });
        return actorResponseDTOList;
    }

    @Override
    public List<ActorResponseDTO> findActorsOverRating(Double rating) {
        List<Actors> actorsList = actorsRepository.findActorsOverRating(rating);
        List<ActorResponseDTO> actorResponseDTOList = new ArrayList<>();
        actorsList.forEach(actor -> {
            actorResponseDTOList.add(new ActorResponseDTO(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovie().getTitle()));
        });
        return actorResponseDTOList;
    }

    @Override
    public List<ActorResponseDTO> findActorsByMovieTitle(String title) {
        List<Actors> actorsList = actorsRepository.findActorsByMovieTitle(title);
        List<ActorResponseDTO> actorResponseDTOList = new ArrayList<>();
        actorsList.forEach(actor -> {
            actorResponseDTOList.add(new ActorResponseDTO(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovie().getTitle()));
        });
        return actorResponseDTOList;
    }
}
