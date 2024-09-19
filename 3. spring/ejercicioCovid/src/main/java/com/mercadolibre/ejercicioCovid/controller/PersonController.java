package com.mercadolibre.ejercicioCovid.controller;

import com.mercadolibre.ejercicioCovid.model.dto.PersonDTO;
import com.mercadolibre.ejercicioCovid.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/riskPersons")
    public List<PersonDTO> findRiskPersons() {
        return personService.findAllRiskPersons();
    }
}
