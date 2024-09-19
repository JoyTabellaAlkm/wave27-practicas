package ar.com.covid.covid19.service.imp;

import ar.com.covid.covid19.entity.Persona;
import ar.com.covid.covid19.entity.Sintoma;
import ar.com.covid.covid19.entity.dto.PersonaDTO;
import ar.com.covid.covid19.service.IDetectorDeCovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetectorDeCovidService implements IDetectorDeCovidService {

    List<Persona> personas = new ArrayList<>();
    List<Sintoma> sintomas = new ArrayList<>();
    List<PersonaDTO> personaDTOS = new ArrayList<>();

    private void cargarPersonas() {
        personas.add(new Persona("38444099","Stephanie", "Castillo",60));
        personas.add(new Persona("38448899","Camila", "Laiza",65));
        personas.add(new Persona("39999099","Celeste", "Carballal",50));
        personas.add(new Persona("32099393","Soledad", "Carbajal",45));
        personas.add(new Persona("42887333","Fernando", "Loude",44));
        personas.add(new Persona("12223388","Facundo", "Llanos",61));
        personas.add(new Persona("22299988","Mauro", "Lopez",62));
        personas.add(new Persona("12121212","Magali", "Castaño",75));
        personas.add(new Persona("92992898","Sofia", "Paredes",96));
        personas.add(new Persona("22211111","Gerard", "Perez",26));
        personas.add(new Persona("21212121","Juan", "Miguel",18));
        personas.add(new Persona("10101010","Matias", "Reinaldo",66));
        personas.add(new Persona("11100993","Leo", "Messi",88));
        personas.add(new Persona("00099999","Luciana", "Waldof",91));
        personas.add(new Persona("30004099","Emilia", "Mernes",64));
    }

    private void cargarSintomas() {
        sintomas.add(new Sintoma("0101","Fiebre",10));
        sintomas.add(new Sintoma("0102","escalofrios",10));
        sintomas.add(new Sintoma("0103","dolor_de_garganta",10));
        sintomas.add(new Sintoma("0104","mareo",10));
        sintomas.add(new Sintoma("0105","ronquera",10));
        sintomas.add(new Sintoma("0106","dolor_ocular",10));
        sintomas.add(new Sintoma("0107","fatiga_o_cansancio_intensos",10));
        sintomas.add(new Sintoma("0108","dificultad_para_dormir",10));
        sintomas.add(new Sintoma("0109","dolor_de_cabeza",10));
        sintomas.add(new Sintoma("0110","dificultad_respiratoria",10));
        sintomas.add(new Sintoma("0111","entumecimiento_u_hormigueo",10));
        sintomas.add(new Sintoma("0112","tos_nueva_y_persistente",10));
        sintomas.add(new Sintoma("0113","opresión_o_dolor_en_el_pecho",10));
        sintomas.add(new Sintoma("0114","secreción_nasal_intensa",10));
        sintomas.add(new Sintoma("0115","dolor_muscular",10));
    }

    private void cargarPersonaDTO() {
        cargarPersonas();
        cargarSintomas();
        for (int i = 0; i < sintomas.size(); i++) {
            personaDTOS.add(new PersonaDTO(personas.get(i).getNombre(), personas.get(i).getApellido(),sintomas.get(i).getNombre()));
        }
    }

    @Override
    public List<Sintoma> findAllSymptom() {
        cargarSintomas();
        return sintomas;
    }

    @Override
    public ResponseEntity<String> findSymptom(String name) {
        cargarSintomas();

        Sintoma sintoma = sintomas.stream()
                .filter(s -> s.getNombre().equals(name))
                .findAny().orElse(null);
        if(sintoma != null) {
            return new ResponseEntity<>("El deporte: "+name+" Tiene nivel de gravedad es:"+sintoma.getNivelDeGravedad(), HttpStatus.OK);
        }
        return  new ResponseEntity<>("El deporte: "+name+" No se encuentra registrado.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<PersonaDTO> findRiskPerson() {
        cargarPersonaDTO();
        cargarPersonas();
        cargarSintomas();

        List<PersonaDTO> personaDeRiesgo = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getEdad() > 60) {
                Sintoma sintomaRiego = sintomas.stream().filter(s -> s.getNombre().equals(persona.getNombre())).findAny().orElse(null);
                PersonaDTO personaAux = new PersonaDTO(persona.getNombre(), persona.getApellido(), sintomaRiego.getNombre());
                personaDeRiesgo.add(personaAux);
            }
        }

        return personaDeRiesgo;
    }
}