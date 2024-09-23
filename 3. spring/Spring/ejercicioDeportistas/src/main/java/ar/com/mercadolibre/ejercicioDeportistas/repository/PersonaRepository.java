package ar.com.mercadolibre.ejercicioDeportistas.repository;

import ar.com.mercadolibre.ejercicioDeportistas.entitys.Deporte;
import ar.com.mercadolibre.ejercicioDeportistas.entitys.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonaRepository {
    Persona persona1 = new Persona("Delfina", "Glavas", 21,
            new Deporte("Voleyball", "Dificil"));

    Persona persona2 = new Persona("Tamara", "Vazquez", 24,
            new Deporte("Basketaball", "Medio"));

    List<Persona> personas = new ArrayList<>(Arrays.asList(persona1,
            persona2));

    public List<Persona> getAllPersonas() {
        return personas;
    }

}
