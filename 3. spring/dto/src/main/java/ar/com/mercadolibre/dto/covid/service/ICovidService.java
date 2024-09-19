package ar.com.mercadolibre.dto.covid.service;

import ar.com.mercadolibre.dto.covid.model.Symptom;
import ar.com.mercadolibre.dto.covid.model.dto.RiskPersonDTO;

import java.util.List;

public interface ICovidService {

    List<Symptom> getSymptomList();

    Symptom getSymptomByName(String name);

    List<RiskPersonDTO> riskPersonList();


}
