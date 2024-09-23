package ar.com.mercadolibre.ejercicioCovid.repository;

import ar.com.mercadolibre.ejercicioCovid.entitys.Sintoma;
import ar.com.mercadolibre.ejercicioCovid.entitys.dto.PersonaDto;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SintomaRepository{
    Sintoma sintoma1 = new Sintoma(1, "Fiebre", "Alto");

    Sintoma sintoma2 = new Sintoma(2, "Pérdida del gusto", "Medio");

    Sintoma sintoma3 = new Sintoma(3, "Tos", "Facil");

    List<Sintoma> sintomas = new ArrayList<>(Arrays.asList(sintoma1,
            sintoma2, sintoma3));

    public List<Sintoma> getAllSymptoms(){
        return sintomas;
    }

    PersonaDto persona1 = new PersonaDto("Delfina", "Glavas", 21,
            new ArrayList<>(Arrays.asList(sintoma1, sintoma3)));

    PersonaDto persona2 = new PersonaDto("Tamara", "Vazquez", 60,
            new ArrayList<>(Arrays.asList(sintoma1, sintoma3)));

    List<PersonaDto> personas = new ArrayList<>(Arrays.asList(persona1,
            persona2));

    public List<PersonaDto> getAllPersonas() {
        return personas;
    }

}
