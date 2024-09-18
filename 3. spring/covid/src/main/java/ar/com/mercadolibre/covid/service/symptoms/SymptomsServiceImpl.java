package ar.com.mercadolibre.covid.service.symptoms;

import ar.com.mercadolibre.covid.dto.SymptomDto;
import ar.com.mercadolibre.covid.entity.Symptom;
import ar.com.mercadolibre.covid.exception.NotFoundException;
import ar.com.mercadolibre.covid.repository.SymptomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SymptomsServiceImpl implements SymptomsService {
    private final SymptomsRepository symptomsRepository;

    public SymptomsServiceImpl() {
        this.symptomsRepository = SymptomsRepository.getInstance();
    }

    public List<SymptomDto> findAll() {
        return symptomsRepository.findAll().stream()
                .map(symptom -> new SymptomDto(symptom.getName(), symptom.getSeverity()))
                .toList();
    }

    public Integer findSeverityByName(String name) {
        Symptom symptom = symptomsRepository.findByName(name);

        if (symptom == null) {
            throw new NotFoundException("Symptom %s does not exist".formatted(name));
        }

        return symptom.getSeverity();
    }

    public String create(SymptomDto symptom) {
        Symptom createdSymptom = new Symptom(UUID.randomUUID(), symptom.name(), symptom.severity());
        symptomsRepository.save(createdSymptom);
        return createdSymptom.getName();
    }
}
