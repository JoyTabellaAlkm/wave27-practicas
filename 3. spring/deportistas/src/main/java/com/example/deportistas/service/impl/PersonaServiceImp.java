package com.example.deportistas.service.impl;

import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.entity.Deporte;
import com.example.deportistas.entity.Persona;
import com.example.deportistas.repository.PersonaRepository;
import com.example.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private PersonaRepository repository = new PersonaRepository();

    @Autowired
    private DeporteServiceImp deporteServiceImp = new DeporteServiceImp();

    @Override
    public List<PersonaDTO> findSportsPersons(String sportName) {
        List<Persona> personas = repository.findAll();


        return personas.stream()
                .filter(persona -> {
                    long idDeporte = persona.getIdDeporte();
                    return deporteServiceImp.findById(idDeporte).getNombre().equals(sportName);
                })
                .map(persona -> {
                    long idDeporte = persona.getIdDeporte();
                    Deporte deporte = deporteServiceImp.findById(idDeporte);
                    return new PersonaDTO(persona.getNombre(), persona.getApellido(), deporte.getNombre());
                })
                .collect(Collectors.toList());
    }
}
