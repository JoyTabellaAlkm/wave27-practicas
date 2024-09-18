package ar.com.mercadolibre.covid.controller;

import ar.com.mercadolibre.covid.dto.SymptomDto;
import ar.com.mercadolibre.covid.service.symptoms.SymptomsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SyntomsController {
    private final SymptomsService symptomsService;

    public SyntomsController(SymptomsService symptomsService) {
        this.symptomsService = symptomsService;
    }

    @GetMapping
    public ResponseEntity<List<SymptomDto>> getSymptoms() {
        List<SymptomDto> symptoms = symptomsService.findAll();
        return ResponseEntity.ok(symptoms);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Integer> getSymptomSeverity(@PathVariable String name) {
        Integer severity = symptomsService.findSeverityByName(name);
        return ResponseEntity.ok(severity);
    }

    @PostMapping
    public ResponseEntity<String> createSymptom(@RequestBody SymptomDto symptom) {
        String name = symptomsService.create(symptom);
        return ResponseEntity.ok(name);
    }
}
