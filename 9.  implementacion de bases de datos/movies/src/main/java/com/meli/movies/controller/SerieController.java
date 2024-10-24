package com.meli.movies.controller;

import com.meli.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/seriesByNumberOfSeasons/{numberOfSeasons}")
    public ResponseEntity<?> seriesByNumberOfSeasons(@PathVariable Integer numberOfSeasons){
        return new ResponseEntity<>(serieService.seriesByNumberOfSeasons(numberOfSeasons), HttpStatus.OK);
    }
}
