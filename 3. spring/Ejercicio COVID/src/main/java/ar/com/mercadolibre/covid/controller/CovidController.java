package ar.com.mercadolibre.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.mercadolibre.covid.service.ICovidService;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    ICovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getAllSymptom(){
        return new ResponseEntity<>(covidService.getAllSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getAllSymptom(@PathVariable String name){
        return new ResponseEntity<>(covidService.getSeverityByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskyPerson")
    public ResponseEntity<?> getRiskyPerson(){
        return new ResponseEntity<>(covidService.getRiskyPerson(), HttpStatus.OK);
    }
}
