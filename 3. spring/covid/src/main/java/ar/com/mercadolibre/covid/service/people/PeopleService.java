package ar.com.mercadolibre.covid.service.people;

import ar.com.mercadolibre.covid.dto.CreatePersonDto;
import ar.com.mercadolibre.covid.dto.PersonDto;

import java.util.List;
import java.util.UUID;

public interface PeopleService {
    List<PersonDto> findRiskPeople();
    UUID create(CreatePersonDto person);
}
