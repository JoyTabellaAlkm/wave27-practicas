package ar.com.mercadolibre.moviesConsultas.controller;

import ar.com.mercadolibre.moviesConsultas.model.dto.response.ActorResponseDTO;
import ar.com.mercadolibre.moviesConsultas.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final IActorService service;

    @GetMapping("/favorite-movie")
    public ResponseEntity<List<ActorResponseDTO>> getFavoriteMovie(){
        List<ActorResponseDTO> responseDTOS = service.findByFavoriteMovie();
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/rating/{rate}")
    public ResponseEntity<List<ActorResponseDTO>> getByRating(@PathVariable Double rate){
        List<ActorResponseDTO> response = service.getByRating(rate);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/title/{title}")
    public ResponseEntity<List<ActorResponseDTO>> getByTitle(@PathVariable String title){
        List<ActorResponseDTO> response = service.getByMovie(title);
        return ResponseEntity.ok(response);
    }
}
