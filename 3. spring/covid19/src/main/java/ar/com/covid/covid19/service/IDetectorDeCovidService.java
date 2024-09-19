package ar.com.covid.covid19.service;

import ar.com.covid.covid19.entity.Sintoma;
import ar.com.covid.covid19.entity.dto.PersonaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDetectorDeCovidService {
    List<Sintoma> findAllSymptom();

    ResponseEntity<String> findSymptom(String name);

    List<PersonaDTO> findRiskPerson();
}
