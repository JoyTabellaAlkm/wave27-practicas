package ar.org.mercadolibre.miniseries.controller;


import ar.org.mercadolibre.miniseries.model.MiniSerie;
import ar.org.mercadolibre.miniseries.service.MiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miniseries")
public class MiniSerieController {


    @Autowired
    private MiniSerieService miniSerieService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMiniSerieById(@PathVariable Long id) {
        return  new ResponseEntity<>(miniSerieService.getMiniSerieById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllMiniSeries() {
        return  new ResponseEntity<>(miniSerieService.getAllMiniSeries(), HttpStatus.OK);
    }

    /*
    @PostMapping
    public MiniSerie createMiniSerie(@RequestBody MiniSerie miniSerie) {
        return miniSerieService.saveMiniSerie(miniSerie);
    }

    @DeleteMapping("/{id}")
    public void deleteMiniSerie(@PathVariable Long id) {
        miniSerieService.deleteMiniSerie(id);
    }*/

}
