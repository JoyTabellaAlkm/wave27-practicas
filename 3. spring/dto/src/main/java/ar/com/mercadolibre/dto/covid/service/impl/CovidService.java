package ar.com.mercadolibre.dto.covid.service.impl;

import ar.com.mercadolibre.dto.covid.model.Symptom;
import ar.com.mercadolibre.dto.covid.model.dto.RiskPersonDTO;
import ar.com.mercadolibre.dto.covid.repository.CovidRepository;
import ar.com.mercadolibre.dto.covid.service.ICovidService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidService implements ICovidService {

    CovidRepository covidRepository = new CovidRepository();


    public List<Symptom> getSymptomList() {
        return covidRepository.getSymptomList();
    }


    public Symptom getSymptomByName(String name) {
        return covidRepository.getSymptomByName(name);
    }


    public List<RiskPersonDTO> riskPersonList() {
        List<RiskPersonDTO> riskPersonDTOList = covidRepository.getRiskPersonDTOS();
        return riskPersonDTOList.stream()
                .filter(person -> person.getAge() > 60)
                .filter(person -> person.getSymptomList() != null)
                .toList();

    }
}
