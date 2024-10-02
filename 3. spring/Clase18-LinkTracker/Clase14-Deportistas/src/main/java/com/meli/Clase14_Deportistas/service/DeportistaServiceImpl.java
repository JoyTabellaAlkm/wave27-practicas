package com.meli.Clase14_Deportistas.service;

import com.meli.Clase14_Deportistas.dto.DeporteDTO;
import com.meli.Clase14_Deportistas.dto.DeportistaDTO;
import com.meli.Clase14_Deportistas.exception.NotFoundException;
import com.meli.Clase14_Deportistas.repository.DeportistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportistaServiceImpl implements IDeportistaService{
    @Autowired
    DeportistasRepository deportistasRepository;

    @Override
    public List<DeporteDTO> findAllSports() {
        return deportistasRepository.findAllSports().stream().map(sport -> new DeporteDTO(sport.getNombre(), sport.getNivel())).toList();
    }

    @Override
    public DeporteDTO findSport(String nombre) {
        DeporteDTO deporte = deportistasRepository.findAllSports().stream()
                .filter(sport->sport.getNombre().equals(nombre))
                .map(sport -> new DeporteDTO(sport.getNombre(),sport.getNivel()))
                .findFirst().orElse(null);

        if (deporte == null){
            throw new NotFoundException("No existe un deporte con ese nombre");
        }
        return deporte;
    }

    @Override
    public List<DeportistaDTO> findSportsPeople() {
        return deportistasRepository.findAllPeople().stream()
                .map(person -> new DeportistaDTO(person.getNombre(), person.getApellido(), person.getDeporte()))
                .toList();
    }
}
