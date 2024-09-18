package ar.com.deportistas.deportistas.service;

import ar.com.deportistas.deportistas.dto.DeportistaDTO;
import ar.com.deportistas.deportistas.dto.model.Deporte;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeportistaService {

    List<Deporte> findAllSports();

    ResponseEntity<String> findSportName(String sportName);

    List<DeportistaDTO> findSportsPersons();
}
