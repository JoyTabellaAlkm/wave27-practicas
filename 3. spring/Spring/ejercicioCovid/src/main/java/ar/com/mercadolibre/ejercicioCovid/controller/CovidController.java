package ar.com.mercadolibre.ejercicioCovid.controller;

import ar.com.mercadolibre.ejercicioCovid.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

    IService iService;

    @Autowired
    public CovidController(IService iService){
        this.iService = iService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> searchAllSymptom(){
        return new ResponseEntity<>(iService.findBySymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getDeporteName(@PathVariable String name) {
        return new ResponseEntity<>(iService.findSimptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getPersonaSymptom(){
        return new ResponseEntity<>(iService.findRiskPerson(), HttpStatus.OK);

    }
}
