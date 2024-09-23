package ar.com.mercadolibre.ejercicioDeportistas.controller;

import ar.com.mercadolibre.ejercicioDeportistas.repository.DeporteRepository;
import ar.com.mercadolibre.ejercicioDeportistas.repository.PersonaRepository;
import ar.com.mercadolibre.ejercicioDeportistas.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeporteController {

    private final IService iService;
    private final DeporteRepository deporteRepository;
    private final PersonaRepository personaRepository;

    @Autowired
    public DeporteController(DeporteRepository deporteRepository, IService iService,
                             PersonaRepository personaRepository){
        this.deporteRepository = deporteRepository;
        this.iService = iService;
        this.personaRepository = personaRepository;
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> getAllDeportes(){
        return new ResponseEntity<>(iService.getAllDeportes(deporteRepository.getAllDeportes()), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getDeporteName(@PathVariable String name) {
        return new ResponseEntity<>(iService.getDeporteName(deporteRepository.getAllDeportes(),
                name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getPersonaDeportista(){
        return new ResponseEntity<>(iService.getPersonaDeportista(personaRepository.getAllPersonas()), HttpStatus.OK);

    }

}
