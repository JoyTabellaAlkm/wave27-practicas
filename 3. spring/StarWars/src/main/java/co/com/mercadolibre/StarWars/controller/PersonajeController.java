package co.com.mercadolibre.StarWars.controller;

import co.com.mercadolibre.StarWars.dto.PersonajeDTO;
import co.com.mercadolibre.StarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonajeController {

    @Autowired
    IPersonajeService iPersonajeService;

    @GetMapping("/personaje/{name}")
    public ResponseEntity<?> getPersonaje (@PathVariable String name){
        PersonajeDTO personajeDTO = iPersonajeService.getPersonaje(name);
        return new ResponseEntity<>(personajeDTO, HttpStatus.OK);

    }

}
