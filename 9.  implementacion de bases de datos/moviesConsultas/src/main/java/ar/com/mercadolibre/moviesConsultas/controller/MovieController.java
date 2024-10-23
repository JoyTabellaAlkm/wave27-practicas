package ar.com.mercadolibre.moviesConsultas.controller;


import ar.com.mercadolibre.moviesConsultas.model.dto.response.MovieResponseDTO;
import ar.com.mercadolibre.moviesConsultas.service.IMoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final IMoviesService service;

    @GetMapping("/actor/{rating}")
    public ResponseEntity<List<MovieResponseDTO>> getMovieByActorRating(@PathVariable Double rating){
        List<MovieResponseDTO> response = service.getMovieByActorRating(rating);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponseDTO>> getMovieByActorRating(@PathVariable Integer genre){
        List<MovieResponseDTO> response = service.getMoviebyGenreId(genre);
        return ResponseEntity.ok(response);
    }
}
