package ar.com.mercadolibre.covid.service.people;

import ar.com.mercadolibre.covid.dto.CreatePersonDto;
import ar.com.mercadolibre.covid.dto.PersonDto;
import ar.com.mercadolibre.covid.entity.Person;
import ar.com.mercadolibre.covid.entity.Symptom;
import ar.com.mercadolibre.covid.repository.PeopleRepository;
import ar.com.mercadolibre.covid.repository.SymptomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;
    private final SymptomsRepository symptomsRepository;

    public PeopleServiceImpl() {
        peopleRepository = PeopleRepository.getInstance();
        symptomsRepository = SymptomsRepository.getInstance();
    }

    public List<PersonDto> findRiskPeople() {
        return peopleRepository.findAllWhere(Person::isRiskPerson).stream()
                .map(person -> new PersonDto(person.getFirstName(), person.getLastName()))
                .toList();
    }

    public UUID create(CreatePersonDto person) {
        Person createdPerson = new Person(person.firstName(), person.lastName(), person.age());
        addSymptoms(createdPerson, person.symptomNames());
        peopleRepository.save(createdPerson);
        return createdPerson.getId();
    }

    private void addSymptoms(Person person, List<String> symptomNames) {
        List<Symptom> symptoms = symptomsRepository.findByNames(symptomNames);
        person.setSymptoms(symptoms);
    }
}
