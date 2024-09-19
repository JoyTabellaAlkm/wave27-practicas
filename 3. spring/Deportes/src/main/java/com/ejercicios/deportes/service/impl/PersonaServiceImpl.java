package com.ejercicios.deportes.service.impl;

import com.ejercicios.deportes.dto.PersonaDTO;
import com.ejercicios.deportes.repository.IPersonaRepository;
import com.ejercicios.deportes.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<PersonaDTO> verPersonasDeportistas() {
        return iPersonaRepository.verPersonasDeportistas();
    }
}
