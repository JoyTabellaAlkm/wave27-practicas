package com.example.deportistas.repository;

import com.example.deportistas.entity.Deporte;
import com.example.deportistas.entity.Nivel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {

    private List<Deporte> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();
        addDeportes();
    }



    public Deporte findById(long id) {
        return deportes.stream()
                .filter(deporte -> deporte.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void addDeportes() {
        Deporte futbol = new Deporte(1, "Futbol", Nivel.MEDIO);
        Deporte basquet = new Deporte(2, "Basquet", Nivel.ALTO);
        Deporte tenis = new Deporte(3, "Tenis", Nivel.ALTO);
        Deporte natacion = new Deporte(4, "Natacion", Nivel.BAJO);

        deportes.add(futbol);
        deportes.add(basquet);
        deportes.add(tenis);
        deportes.add(natacion);
    }

    public Deporte findByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Deporte> findAll() {
        return deportes;
    }
}
