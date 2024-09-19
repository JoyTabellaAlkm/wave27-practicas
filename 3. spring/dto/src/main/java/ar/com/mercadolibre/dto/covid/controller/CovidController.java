package ar.com.mercadolibre.dto.covid.controller;

import ar.com.mercadolibre.dto.covid.model.Symptom;
import ar.com.mercadolibre.dto.covid.model.dto.RiskPersonDTO;
import ar.com.mercadolibre.dto.covid.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    ICovidService covidService;


    @GetMapping("/find-symptom")
    public ResponseEntity<List<Symptom>> getSymptomList(){
        List<Symptom>  response = covidService.getSymptomList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find-symptom/{name}")
    public ResponseEntity<?> getSymptomByName(@PathVariable String name){
        Symptom symptom = covidService.getSymptomByName(name);

        if (symptom == null){
            return ResponseEntity.status(404).body("There is no Symptom with the name: " + name);
        }


        return ResponseEntity.ok(symptom);
    }

    @GetMapping("/find-risk-person")
    public ResponseEntity<List<RiskPersonDTO>> getRiskPersonList(){
        List<RiskPersonDTO> response = covidService.riskPersonList();
        return ResponseEntity.ok(response);
    }


}
