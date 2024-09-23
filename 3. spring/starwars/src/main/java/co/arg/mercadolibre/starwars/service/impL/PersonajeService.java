package co.arg.mercadolibre.starwars.service.impL;

import co.arg.mercadolibre.starwars.dto.PersonajeDTO;
import co.arg.mercadolibre.starwars.repository.PersonajeRepository;
import co.arg.mercadolibre.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {

        return personajeRepository.fillPersonaje().stream()
                .filter(p -> p.getName().contains(name))
                .map(p -> new PersonajeDTO(p.getName(),p.getHeight(),
                     p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies()))
                .toList();

    }
}
