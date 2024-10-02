package com.edad.Clase14_Deportistas.repository;

import com.edad.Clase14_Deportistas.entity.Deporte;
import com.edad.Clase14_Deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeportistaRepository {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();
    private Map<Persona, Deporte> deportistas = new HashMap<>();

    public DeportistaRepository(){
        Deporte deporte1 = new Deporte("Futbol", "Básico");
        deportes.add(deporte1);
        Deporte deporte2 = new Deporte("Voleiball", "Avanzado");
        deportes.add(deporte2);
        Deporte deporte3 = new Deporte("Natación", "Intermedio");
        deportes.add(deporte3);
        Deporte deporte4 = new Deporte("Basketball", "Básico");
        deportes.add(deporte4);
        Persona persona1 = new Persona("Maria", "Mar", 20);
        personas.add(persona1);
        Persona persona2 = new Persona("Jose", "Pepe", 23);
        personas.add(persona2);
        Persona persona3 = new Persona("Vale", "Landinez", 40);
        personas.add(persona3);
        Persona persona4 = new Persona("Max", "Lozano", 10);
        personas.add(persona4);

        deportistas.put(persona1,deporte1);
        deportistas.put(persona3,deporte4);
        deportistas.put(persona4,deporte2);

    }

    public List<Deporte> getAllSports(){
        return deportes;
    }

    public Map<Persona, Deporte> getAllSportPeople(){
        return deportistas;
    }

}
