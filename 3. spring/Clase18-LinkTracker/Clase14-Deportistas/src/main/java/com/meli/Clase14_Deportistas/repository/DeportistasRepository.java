package com.meli.Clase14_Deportistas.repository;

import com.meli.Clase14_Deportistas.entity.Deporte;
import com.meli.Clase14_Deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistasRepository {
    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public DeportistasRepository(){
        deportes.add(new Deporte("Fútbol", "Básico"));
        deportes.add(new Deporte("Basquetball", "Medio"));
        deportes.add(new Deporte("Volleibol", "Básico"));
        deportes.add(new Deporte("Natación", "Avanzado"));
        personas.add(new Persona("Maria", "Mar", 21, "Fútbol"));
        personas.add(new Persona("Jose", "Jaime", 33, "Natación"));
        personas.add(new Persona("Pepe", "Perez", 24, "Volleibol"));

    }

    public List<Deporte> findAllSports(){
        return deportes;
    }


    public List<Persona> findAllPeople(){
        return personas;
    }
}
