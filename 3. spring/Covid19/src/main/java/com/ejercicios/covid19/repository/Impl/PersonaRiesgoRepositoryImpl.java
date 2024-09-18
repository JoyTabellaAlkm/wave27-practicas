package com.ejercicios.covid19.repository.Impl;

import com.ejercicios.covid19.dto.PersonaRiesgoDTO;
import com.ejercicios.covid19.model.Persona;
import com.ejercicios.covid19.repository.IPersonaRiesgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRiesgoRepositoryImpl implements IPersonaRiesgoRepository {
   List<PersonaRiesgoDTO> listaPersonasRiesgo = new ArrayList<>();
@Autowired
PersonaRepositoryImpl personaRepository;
    public PersonaRiesgoRepositoryImpl() {
    for(Persona perso : personaRepository.listaPersonas){
        if(perso.getEdad()> 60 && perso.getSintoma().ge)
        listaPersonasRiesgo.add(new PersonaRiesgoDTO());

    }
    }

    @Override
    public List<PersonaRiesgoDTO> verPersonasRiesgo() {

    }
}
