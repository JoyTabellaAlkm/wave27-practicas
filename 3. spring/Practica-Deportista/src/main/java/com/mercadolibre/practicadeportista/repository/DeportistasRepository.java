package com.mercadolibre.practicadeportista.repository;

import com.mercadolibre.practicadeportista.model.Deporte;
import com.mercadolibre.practicadeportista.model.DeportistaDTO;
import com.mercadolibre.practicadeportista.service.impl.Deportista;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DeportistasRepository {
    @Getter
    private List<Deporte> deportes = new ArrayList<>();
    private List<DeportistaDTO> deportistasDTO = new ArrayList<>();

    public DeportistasRepository() {
        deportes.add(new Deporte("voley", 1));
        deportes.add(new Deporte("futbol", 2));
        deportes.add(new Deporte("tenis", 3));

        deportistasDTO.add(new DeportistaDTO("Pepe", "Lopez", deportes.get(0).getNombre()));
        deportistasDTO.add(new DeportistaDTO("Ana", "Perez", deportes.get(1).getNombre()));
        deportistasDTO.add(new DeportistaDTO("Lucia", "Perez", deportes.get(2).getNombre()));

    }
    public Deporte getDeporte(String nombre) {
        return this.deportes.stream().filter(deporte -> deporte.getNombre().equals(nombre)).findFirst().orElse(null);
    }
    public List<DeportistaDTO> getDeportistaDTO() {
        return deportistasDTO;
    }
}
