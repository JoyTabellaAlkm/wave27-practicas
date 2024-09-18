package ar.com.mercadolibre.covid.service.symptoms;

import ar.com.mercadolibre.covid.dto.SymptomDto;

import java.util.List;

public interface SymptomsService {
    List<SymptomDto> findAll();
    Integer findSeverityByName(String name);
    String create(SymptomDto symptom);
}
