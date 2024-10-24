package com.meli.movies.controller;

import com.meli.movies.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;

    @GetMapping("/episodeByActor/{actorName}")
    public ResponseEntity<?> episodeByActor(@PathVariable String actorName){
        return new ResponseEntity<>(episodeService.episodeByActor(actorName), HttpStatus.OK);
    }

}
