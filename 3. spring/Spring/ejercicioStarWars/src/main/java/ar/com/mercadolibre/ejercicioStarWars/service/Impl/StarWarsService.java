package ar.com.mercadolibre.ejercicioStarWars.service.Impl;

import ar.com.mercadolibre.ejercicioStarWars.repository.StarWarsRepository;
import ar.com.mercadolibre.ejercicioStarWars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StarWarsService implements IService {

    private final StarWarsRepository starWarsRepository;

    @Autowired
    public StarWarsService(StarWarsRepository starWarsRepository){
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<String> getPersonajeName(String name){
        String jsonData = starWarsRepository.getJSONData();
        return new ArrayList<>();
    }
}
