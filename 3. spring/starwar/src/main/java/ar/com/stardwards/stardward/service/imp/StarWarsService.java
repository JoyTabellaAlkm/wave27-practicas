package ar.com.stardwards.stardward.service.imp;

import ar.com.stardwards.stardward.dto.PersonajeDTO;
import ar.com.stardwards.stardward.entity.Personaje;
import ar.com.stardwards.stardward.repository.StarwarsRepository;
import ar.com.stardwards.stardward.service.IStarwarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarwarService {

    @Autowired
    private StarwarsRepository starwarsRepository;

    private List<PersonajeDTO> formatoPersonajeDTO(List<PersonajeDTO> personajeDTOS) {
        List<Personaje> personajes = starwarsRepository.leerArchivo();

        personajes.stream().forEach(p -> {
            PersonajeDTO perAux = new PersonajeDTO(p.getName(),p.getHeight(), p.getMass(),p.getGender(),p.getHomeworld(), p.getSpecies());
            personajeDTOS.add(perAux);
        });
        return personajeDTOS;
    }

    @Override
    public List<PersonajeDTO> buscarPersonajes(String name) {
        List<PersonajeDTO> personajesDTO = formatoPersonajeDTO(new ArrayList<>());

        return personajesDTO.stream().filter(p -> p.getName().contains(name)).toList();
    }
}
