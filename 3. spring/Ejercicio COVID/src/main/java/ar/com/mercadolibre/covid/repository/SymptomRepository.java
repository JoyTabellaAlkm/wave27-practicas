package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class SymptomRepository implements ISymptomRepository {
    private HashMap<String, Symptom> symptoms;

    private SymptomRepository() {
        symptoms = new HashMap<>();
    }

    @Override
    public List<Symptom> findAll(){
        return symptoms.values()
                .stream().toList();
    }
}
