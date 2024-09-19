package com.mercadolibre.ejercicioCovid.controller;

import com.mercadolibre.ejercicioCovid.model.dto.SymptomDTO;
import com.mercadolibre.ejercicioCovid.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SymptomRestController {
    private SymptomService symptomService;

    @Autowired
    public SymptomRestController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping("/symptoms")
    public List<SymptomDTO> findAll() {
        return symptomService.findAll();
    }

    @GetMapping("/symptoms/{name}")
    public SymptomDTO findByName(@PathVariable String name) {
        return symptomService.findByName(name);
    }
}
