package ar.com.deportistas.deportistas.service.impl;

import ar.com.deportistas.deportistas.dto.DeportistaDTO;
import ar.com.deportistas.deportistas.dto.model.Deporte;
import ar.com.deportistas.deportistas.dto.model.Persona;
import ar.com.deportistas.deportistas.service.IDeportistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportistaService implements IDeportistaService {

    List<Persona> personas = new ArrayList<>();
    List<Deporte> deportes = new ArrayList<>();
    List<DeportistaDTO> deportistaDTOs = new ArrayList<>();

    private void cargarPersonas() {
        personas.add(new Persona("Stephanie", "Castillo",20));
        personas.add(new Persona("Camila", "Laiza",18));
        personas.add(new Persona("Celeste", "Carballal",22));
        personas.add(new Persona("Soledad", "Carbajal",23));
        personas.add(new Persona("Fernando", "Loude",34));
        personas.add(new Persona("Facundo", "Llanos",25));
        personas.add(new Persona("Mauro", "Lopez",20));
        personas.add(new Persona("Magali", "Castaño",28));
        personas.add(new Persona("Sofia", "Paredes",29));
        personas.add(new Persona("Gerard", "Perez",26));
        personas.add(new Persona("Juan", "Miguel",27));
        personas.add(new Persona("Maria", "Becerra",28));
        personas.add(new Persona("Victor", "Venniel",29));
        personas.add(new Persona("Hugo", "Cañuelas",18));
        personas.add(new Persona("Matias", "Reinaldo",19));
        personas.add(new Persona("Leo", "Messi",23));
        personas.add(new Persona("Luciana", "Waldof",21));
        personas.add(new Persona("Emilia", "Mernes",22));
    }

    private void cargarDeportes() {
        deportes.add(new Deporte(10,"Fotboll"));
        deportes.add(new Deporte(11,"Ajedrez"));
        deportes.add(new Deporte(12,"Atletismo"));
        deportes.add(new Deporte(13,"Badminton"));
        deportes.add(new Deporte(14,"Basquetbol"));
        deportes.add(new Deporte(15,"Beisbol"));
        deportes.add(new Deporte(16,"Boliche"));
        deportes.add(new Deporte(17,"Box"));
        deportes.add(new Deporte(18,"Ciclismo"));
        deportes.add(new Deporte(19,"Frontón"));
        deportes.add(new Deporte(9,"Futbol"));
        deportes.add(new Deporte(8,"Handball"));
        deportes.add(new Deporte(7,"Judo"));
        deportes.add(new Deporte(6,"Karate"));
        deportes.add(new Deporte(5,"Lucha"));
        deportes.add(new Deporte(4,"Natación"));
        deportes.add(new Deporte(3,"Tenis"));
        deportes.add(new Deporte(2,"Voleibol"));
    }

    private void cargarDeportistas() {
        cargarPersonas();
        cargarDeportes();
        for (int i = 0; i < deportes.size(); i++) {
            deportistaDTOs.add(new DeportistaDTO(personas.get(i).getNombre(), personas.get(i).getApellido(),deportes.get(i).getNombre()));
        }
    }

    @Override
    public ResponseEntity<String> findSportName(String sportName) {
        cargarDeportes();

        Deporte deporte = deportes.stream()
                        .filter(d -> d.getNombre().equals(sportName))
                        .findAny().orElse(null);
        if(deporte != null) {
            return new ResponseEntity<>("El deporte: "+sportName+" Tiene nivel:"+deporte.getNivel(), HttpStatus.OK);
        }
        return  new ResponseEntity<>("El deporte: "+sportName+" No se encuentra registrado.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<DeportistaDTO> findSportsPersons() {
        cargarDeportistas();
        return deportistaDTOs;
    }

    @Override
    public List<Deporte> findAllSports() {
        cargarDeportes();
        return this.deportes;
    }
}
