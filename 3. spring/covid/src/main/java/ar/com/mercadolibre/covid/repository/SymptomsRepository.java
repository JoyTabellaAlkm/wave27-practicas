package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Symptom;
import ar.com.mercadolibre.covid.exception.ValidationException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Predicate;

@Repository
public class SymptomsRepository {
    private static SymptomsRepository instance;

    private final HashMap<String, Symptom> symptoms;

    private SymptomsRepository() {
        symptoms = new HashMap<>();
    }

    public static SymptomsRepository getInstance() {
        if (instance == null)
            instance = new SymptomsRepository();

        return instance;
    }

    public List<Symptom> findAll() {
        return symptoms.values().stream().toList();
    }

    public List<Symptom> findAllWhere(Predicate<Symptom> predicate) {
        return symptoms.values().stream().filter(predicate).toList();
    }

    public Symptom findByName(String name) {
        return symptoms.get(name);
    }

    public List<Symptom> findByNames(List<String> names) {
        return names.stream()
                .map(this.symptoms::get)
                .filter(Objects::nonNull)
                .toList();
    }

    public void save(Symptom symptom) {
        if (symptoms.containsKey(symptom.getName())) {
            throw new ValidationException("Symptom %s already exists.".formatted(symptom.getName()));
        }

        symptoms.put(symptom.getName(), symptom);
    }
}
