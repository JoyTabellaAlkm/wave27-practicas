package co.mercadolibre.covid.controller;

import co.mercadolibre.covid.service.IPersonaService;
import co.mercadolibre.covid.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidControlador {
    @Autowired
    ISintomaService iSintomaService;

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getSymptoms(){
        return new ResponseEntity<>(iSintomaService.getAllSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(iSintomaService.getSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getRiskPerson(){
        return new ResponseEntity<>(iPersonaService.getRiskPerson(), HttpStatus.OK);
    }

}
