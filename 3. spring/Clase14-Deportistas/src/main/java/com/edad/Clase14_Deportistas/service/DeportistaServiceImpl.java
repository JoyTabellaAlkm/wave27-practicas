package com.edad.Clase14_Deportistas.service;

import com.edad.Clase14_Deportistas.dto.DeporteDto;
import com.edad.Clase14_Deportistas.dto.DeportistaDto;
import com.edad.Clase14_Deportistas.entity.Persona;
import com.edad.Clase14_Deportistas.exceptions.NotFoundException;
import com.edad.Clase14_Deportistas.repository.DeportistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportistaServiceImpl implements IDeportistasService{
    @Autowired
    DeportistaRepository deportistaRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<DeporteDto> findSports() {
        return deportistaRepository.getAllSports().stream()
                .map(deporte -> mapper.convertValue(deporte, DeporteDto.class))
                .toList();
    }

    @Override
    public List<DeporteDto> findSportByName(String name) {
        List<DeporteDto> sportByName = deportistaRepository.getAllSports().stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .map(deporte -> mapper.convertValue(deporte, DeporteDto.class))
                .toList();
        if (sportByName.isEmpty()){
            throw new NotFoundException("Deporte %s no encontrado".formatted(name));
        }
        return sportByName;
    }

    @Override
    public List<DeportistaDto> findSportPeople() {
        return deportistaRepository.getAllSportPeople().keySet().stream()
                .map(persona -> new DeportistaDto(persona.getNombre(), persona.getApellido(), deportistaRepository.getAllSportPeople().get(persona).getNombre()))
                .toList();
    }
}
