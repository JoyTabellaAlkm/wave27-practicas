package ar.com.mercadolibre.dto.sportman.controller;


import ar.com.mercadolibre.dto.sportman.model.Sport;
import ar.com.mercadolibre.dto.sportman.model.SportmanDTO;
import ar.com.mercadolibre.dto.sportman.service.ISportmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sportman")
public class SportmanController {

    @Autowired
    ISportmanService sportmanService;


    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getSportList(){
        List<Sport> response = sportmanService.getSportList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSport(@PathVariable String name){
        Sport response = sportmanService.getSport(name);

        if (response == null) {
            return ResponseEntity.status(404).body("Sport Not Found");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportmanDTO>> getSportmanList(){
        List<SportmanDTO> response = sportmanService.getSportmanList();
        return ResponseEntity.ok(response);
    }

}
