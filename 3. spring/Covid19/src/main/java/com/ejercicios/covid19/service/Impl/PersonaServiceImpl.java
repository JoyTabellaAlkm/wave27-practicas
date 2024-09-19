package com.ejercicios.covid19.service.Impl;

import com.ejercicios.covid19.dto.PersonaRiesgoDTO;
import com.ejercicios.covid19.repository.Impl.PersonaRepositoryImpl;
import com.ejercicios.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

@Autowired
    PersonaRepositoryImpl personaRepository;
PersonaRiesgoDTO personaRiesgoDTO = new PersonaRiesgoDTO();

    @Override
    public List<PersonaRiesgoDTO> verPersonasConRiesgo() {
        if(personaRepository.verPersonasConRiesgo().isEmpty()){
            return null;
        }
        return personaRepository.verPersonasConRiesgo();
    }
}
