package ar.com.mercadolibre.covid.service;

import ar.com.mercadolibre.covid.dto.PersonDto;
import ar.com.mercadolibre.covid.dto.SymptomDto;
import ar.com.mercadolibre.covid.entity.Symptom;
import ar.com.mercadolibre.covid.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.mercadolibre.covid.repository.PeopleRepository;
import ar.com.mercadolibre.covid.repository.SymptomRepository;

import java.util.List;

@Service
public class CovidServiceImpl implements ICovidService{
    @Autowired
    SymptomRepository symptomRepository;
    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public List<SymptomDto> getAllSymptom() {
        return symptomRepository.findAll().stream()
                .map(sym -> new SymptomDto(sym.getName(), sym.getSeverityLevel()))
        .toList();
    }

    @Override
    public int getSeverityByName(String name) {
        Symptom symptom = symptomRepository.findAll().stream()
                .filter(sym->sym.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Symptom not found"));

        return symptom.getSeverityLevel();
    }

    @Override
    public List<PersonDto> getRiskyPerson() {
        return peopleRepository.findAll()
                .stream()
                .filter(p->p.isRiskyPerson())
                .map(person -> new PersonDto(person.getName(), person.getLastName()))
                .toList();
    }
}
