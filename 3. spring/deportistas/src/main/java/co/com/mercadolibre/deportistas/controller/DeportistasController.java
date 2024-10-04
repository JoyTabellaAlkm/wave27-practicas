package co.com.mercadolibre.deportistas.controller;


import co.com.mercadolibre.deportistas.entity.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DeportistasController {


    public List<Deporte> deportes = List.of(new Deporte(1L,"Natacion","Basico"), new Deporte(2L,"Baloncesto","Avanzado"));

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports (){

        return null;
    }
}
