package ar.com.mercadolibre.starwars.service;

import ar.com.mercadolibre.starwars.dto.PersonajeDto;
import ar.com.mercadolibre.starwars.repository.PersonajesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesServiceImpl implements PersonajesService {
    private final PersonajesRepository personajesRepository;

    public PersonajesServiceImpl(PersonajesRepository personajesRepository) {
        this.personajesRepository = personajesRepository;
    }

    public List<PersonajeDto> getFiltered(String nombre) {
        return personajesRepository.findAll().stream()
                .filter(personaje -> personaje.getName().contains(nombre))
                .map(personaje -> new PersonajeDto(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getHairColor(),
                        personaje.getSkinColor(),
                        personaje.getEyeColor(),
                        personaje.getBirthYear(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                )).toList();
    }
}
