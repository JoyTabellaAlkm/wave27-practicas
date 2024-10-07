package ar.com.mercadolibre.covid.service;

import ar.com.mercadolibre.covid.dto.PersonDto;
import ar.com.mercadolibre.covid.dto.SymptomDto;

import java.util.List;

public interface ICovidService {
    List<SymptomDto> getAllSymptom();
    int getSeverityByName(String name);
    List<PersonDto> getRiskyPerson();
}
