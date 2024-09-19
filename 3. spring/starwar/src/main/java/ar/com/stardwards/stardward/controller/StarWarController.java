package ar.com.stardwards.stardward.controller;

import ar.com.stardwards.stardward.dto.PersonajeDTO;
import ar.com.stardwards.stardward.service.imp.StarWarsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwar")
public class StarWarController {
    private final StarWarsService service;

    public StarWarController(StarWarsService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    @ResponseBody
    public List<PersonajeDTO> buscarPersonaje(@PathVariable String name) {
        return service.buscarPersonajes(name);
    }
}
