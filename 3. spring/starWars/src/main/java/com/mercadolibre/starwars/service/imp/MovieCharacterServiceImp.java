package com.mercadolibre.starwars.service.imp;

import com.mercadolibre.starwars.dto.MovieCharacterDTO;
import com.mercadolibre.starwars.repository.MovieCharacterRepository;
import com.mercadolibre.starwars.service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieCharacterServiceImp implements MovieCharacterService {

    @Autowired
    MovieCharacterRepository repository;

    @Override
    public List<MovieCharacterDTO> findByName(String name) {
         return repository.findByName(name).stream()
                    .map(mc -> new MovieCharacterDTO(mc.getName(), mc.getHeight(), mc.getMass(), mc.getGender(),
                            mc.getHomeworld(), mc.getSpecies()))
                    .collect(Collectors.toList());
    }
}
