package org.example.deportistas_ejercicio.services.deportes;

import org.example.deportistas_ejercicio.entities.Deporte;
import org.example.deportistas_ejercicio.repositories.deportes.IDeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeporteService implements IDeporteService {
    @Autowired
    private IDeporteRepository deporteRepository;

    @Override
    public List<Deporte> findSports() {
        return deporteRepository.getAll();
    }

    @Override
    public Optional<Integer> getNivelByDeporte(String nombre) {
        Optional<Deporte> deporte = findSports().stream().filter(d -> d.getNombre().equals(nombre)).findFirst();
        return deporte.map(Deporte::getNivel);
    }
}
