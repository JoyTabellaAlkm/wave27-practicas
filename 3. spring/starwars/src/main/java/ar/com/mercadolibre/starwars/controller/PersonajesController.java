package ar.com.mercadolibre.starwars.controller;

import ar.com.mercadolibre.starwars.dto.PersonajeDto;
import ar.com.mercadolibre.starwars.service.PersonajesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajesController {

    private final PersonajesService personajesService;

    public PersonajesController(PersonajesService personajesService) {
        this.personajesService = personajesService;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getFiltered(@RequestParam(required = false) String nombre) {
        List<PersonajeDto> personajes = personajesService.getFiltered(nombre != null ? nombre : "");
        return ResponseEntity.ok(personajes);
    }
}
