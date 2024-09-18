package com.mercadolibre.deportista.service;

import com.mercadolibre.deportista.dto.DeportistaDTO;
import com.mercadolibre.deportista.model.Deportista;
import com.mercadolibre.deportista.model.Deporte;
import com.mercadolibre.deportista.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistaFinderImpl implements IDeportistaFinder{

    //A falta de tiempo les proporciono la siguiente solucion :)
    List<Deporte> deportes = List.of(
            new Deporte(1,"Futbol","Intermedio"),
            new Deporte(2,"Basketball", "Avanzado")
    );

    List<Deportista> deportistas = List.of(
            new Deportista(
                    new Deporte(1,"Futbol","Intermedio"),
                    new Persona(1, "Pedro", "Perez",21)
            )
    );

    public List<Deporte> getDeportes(){
        return deportes;
    }

    @Override
    public String checkDeporte(String name) {

        Deporte unDeporte = deportes.stream()
                .filter(deporte -> deporte.getNombre().equals(name)).findFirst().get();

        return unDeporte.getNivel();
    }

    public List<DeportistaDTO> getDeportistas(){

        List<DeportistaDTO> deportistaDTOS = new ArrayList<>();

        for (Deportista deportistaIterado : deportistas){
            DeportistaDTO deporstistaDTO = new DeportistaDTO(
                    deportistaIterado.getPersona().getNombre(),
                    deportistaIterado.getPersona().getApellido(),
                    deportistaIterado.getDeporte().getNombre()
            );

            deportistaDTOS.add(deporstistaDTO);
        }

        return deportistaDTOS;
    }

}