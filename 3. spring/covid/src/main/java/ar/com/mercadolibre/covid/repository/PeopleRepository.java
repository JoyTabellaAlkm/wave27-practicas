package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

@Repository
public class PeopleRepository {
    private static PeopleRepository instance;

    private final Map<UUID, Person> people;

    private PeopleRepository() {
        people = new HashMap<>();
    }

    public static PeopleRepository getInstance() {
        if (instance == null)
            instance = new PeopleRepository();

        return instance;
    }

    public List<Person> findAll() {
        return people.values().stream().toList();
    }

    public List<Person> findAllWhere(Predicate<Person> predicate) {
        return people.values().stream().filter(predicate).toList();
    }

    public void save(Person person) {
        person.setId(getFreeId());
        people.put(person.getId(), person);
    }

    private UUID getFreeId() {
        for (int i = 0; i < 10; i++) {
            UUID id = UUID.randomUUID();

            if (!people.containsKey(id))
                return id;
        }

        throw new RuntimeException("Failed to find a free UUID after 10 retries");
    }
}
