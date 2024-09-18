package ar.com.mercadolibre.covid.controller;

import ar.com.mercadolibre.covid.dto.CreatePersonDto;
import ar.com.mercadolibre.covid.dto.PersonDto;
import ar.com.mercadolibre.covid.service.people.PeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/risky")
    public ResponseEntity<List<PersonDto>> getRiskPeople() {
        List<PersonDto> riskPeople = peopleService.findRiskPeople();
        return ResponseEntity.ok(riskPeople);
    }

    @PostMapping
    public ResponseEntity<UUID> createPerson(@RequestBody CreatePersonDto person) {
        UUID id = peopleService.create(person);
        return ResponseEntity.ok(id);
    }
}
