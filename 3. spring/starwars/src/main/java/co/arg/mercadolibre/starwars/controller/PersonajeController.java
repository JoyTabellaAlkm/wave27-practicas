package co.arg.mercadolibre.starwars.controller;

import co.arg.mercadolibre.starwars.dto.PersonajeDTO;
import co.arg.mercadolibre.starwars.entity.Personaje;
import co.arg.mercadolibre.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    IPersonajeService iPersonajeService;

    @GetMapping("api/personaje/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name){
        List<PersonajeDTO> personajeDTO = iPersonajeService.getPersonaje(name);
        return new ResponseEntity<>(personajeDTO, HttpStatus.OK);
    }

}
