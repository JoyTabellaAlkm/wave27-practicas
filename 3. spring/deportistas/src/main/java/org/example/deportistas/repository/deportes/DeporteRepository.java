package org.example.deportistas.repository.deportes;

import org.example.deportistas.entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository{
    public List<Deporte> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();

        Deporte futbol = new Deporte("futbol", 2);
        deportes.add(new Deporte("jockey", 3));
        deportes.add(futbol);
    }

    @Override
    public List<Deporte> getAll() {
        return deportes;
    }
}
