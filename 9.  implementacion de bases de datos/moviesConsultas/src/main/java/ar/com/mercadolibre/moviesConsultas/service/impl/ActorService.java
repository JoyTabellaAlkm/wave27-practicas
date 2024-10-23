package ar.com.mercadolibre.moviesConsultas.service.impl;

import ar.com.mercadolibre.moviesConsultas.model.dto.response.ActorResponseDTO;
import ar.com.mercadolibre.moviesConsultas.repository.ActorRepository;
import ar.com.mercadolibre.moviesConsultas.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ActorService implements IActorService {

    private final ActorRepository repository;
    private final ModelMapper modelMapper;

    public List<ActorResponseDTO> findByFavoriteMovie(){

        return repository.findByFavoriteMovie().stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<ActorResponseDTO> getByRating(Double rating){
        return repository.findActorByRating(rating).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<ActorResponseDTO> getByMovie(String title){
        return repository.findActorsByMovieTitle(title).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class))
                .collect(Collectors.toList());
    }


}
