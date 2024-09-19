package org.example.deportistas.repository.personas;

import org.example.deportistas.entity.Deporte;
import org.example.deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository {
    public List<Persona> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        Persona fernando = new Persona("fernando", "baldrich", 23);
        personas.add(fernando);

        //hace deporte
        Persona messi = new Persona("lionel", "messi", 37);
        Deporte futbol = new Deporte("futbol", 2);

        messi.setDeporte(futbol);
        personas.add(messi);
    }

    @Override
    public List<Persona> getAll() {
        return personas;
    }
}
