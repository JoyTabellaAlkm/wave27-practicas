package co.com.mercadolibre.StarWars.service.impl;

import co.com.mercadolibre.StarWars.dto.PersonajeDTO;
import co.com.mercadolibre.StarWars.repository.PersonajeRepository;
import co.com.mercadolibre.StarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceimpl implements IPersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
    @Override
    public PersonajeDTO getPersonaje(String name) {

        return null;
    }
}
