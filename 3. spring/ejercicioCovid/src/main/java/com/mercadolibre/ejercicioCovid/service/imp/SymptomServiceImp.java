package com.mercadolibre.ejercicioCovid.service.imp;

import com.mercadolibre.ejercicioCovid.model.dto.SymptomDTO;
import com.mercadolibre.ejercicioCovid.model.entity.GravityLevel;
import com.mercadolibre.ejercicioCovid.model.entity.Symptom;
import com.mercadolibre.ejercicioCovid.service.SymptomService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SymptomServiceImp implements SymptomService {
    Map<String, Symptom> symptoms = new HashMap<>();

    public List<SymptomDTO> findAll() {
        addSymptoms();
        return symptoms.values().stream()
                .map(s -> new SymptomDTO(
                        s.getName(),
                        s.getGravityLevel()
                )).toList();
    }

    public SymptomDTO findByName(String name) {
        Symptom symptom = symptoms.get(name);

        return new SymptomDTO(symptom.getName(), symptom.getGravityLevel());
    }

    // Generate a method that generate random symptoms and then add them to the map
    private void addSymptoms() {
        Symptom symptom = new Symptom();
        symptom.setName("Fiebre");
        symptom.setCodigo(1);
        symptom.setGravityLevel(GravityLevel.MEDIUM);
        symptoms.put(symptom.getName(), symptom);

        // now following this pattern, add 2 more symptoms
        Symptom symptom2 = new Symptom();
        symptom2.setName("Tos");
        symptom2.setCodigo(2);
        symptom2.setGravityLevel(GravityLevel.LOW);
        symptoms.put(symptom2.getName(), symptom2);

        Symptom symptom3 = new Symptom();
        symptom3.setName("Dolor de cabeza");
        symptom3.setCodigo(3);
        symptom3.setGravityLevel(GravityLevel.HIGH);
        symptoms.put(symptom3.getName(), symptom3);

    }
}
