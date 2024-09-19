package com.ejercicios.deportes.repository.impl;

import com.ejercicios.deportes.dto.DeporteDTO;
import com.ejercicios.deportes.model.Deporte;
import com.ejercicios.deportes.repository.IDeporteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepositoryImpl implements IDeporteRepository {
    List<DeporteDTO> listaDeportesDTO = new ArrayList<>();
    List<Deporte> listaDeportes = new ArrayList<>();

    public DeporteRepositoryImpl() {
        Deporte deporte1 = new Deporte(1L, "Futbol", "Alto");
        Deporte deporte2 = new Deporte(2L, "Baloncesto", "Alto");
        Deporte deporte3 = new Deporte(3L, "Bowling", "Bajo");
        listaDeportes.add(deporte1);
        listaDeportes.add(deporte2);
        listaDeportes.add(deporte3);


        DeporteDTO deporteDTO1 = new DeporteDTO(deporte1.getNombre(), deporte1.getNivel());
        listaDeportesDTO.add(deporteDTO1);
        DeporteDTO deporteDTO2 = new DeporteDTO(deporte2.getNombre(), deporte1.getNivel());
        listaDeportesDTO.add(deporteDTO2);
        DeporteDTO deporteDTO3 = new DeporteDTO(deporte3.getNombre(), deporte3.getNivel());
        listaDeportesDTO.add(deporteDTO3);

    }

    @Override
    public List<DeporteDTO> verDeportes() {
        return listaDeportesDTO;
    }
}
