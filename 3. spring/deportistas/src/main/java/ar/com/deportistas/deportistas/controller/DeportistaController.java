package ar.com.deportistas.deportistas.controller;

import ar.com.deportistas.deportistas.dto.DeportistaDTO;
import ar.com.deportistas.deportistas.dto.model.Deporte;
import ar.com.deportistas.deportistas.service.impl.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sportsman")
public class DeportistaController {

    @Autowired
    private DeportistaService deportistaService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> findSports(){
        return deportistaService.findAllSports();
    }

    @GetMapping("/findsport/{sportName}")
    ResponseEntity<String> findSportName(@PathVariable String sportName){
        return deportistaService.findSportName(sportName);
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DeportistaDTO> findSportsPersons(){
        return deportistaService.findSportsPersons();
    }
}
