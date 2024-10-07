package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PeopleRepository {
    private final Map<Integer, Person> people;
    private PeopleRepository(){
        people = new HashMap<>();
    }

    public List<Person> findAll() {
        return people.values().stream().toList();
    }

}
