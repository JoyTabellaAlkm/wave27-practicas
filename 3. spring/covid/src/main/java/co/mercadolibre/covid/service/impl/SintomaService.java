package co.mercadolibre.covid.service.impl;

import co.mercadolibre.covid.entity.Sintoma;
import co.mercadolibre.covid.repository.CovidRepository;
import co.mercadolibre.covid.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaService implements ISintomaService {

    @Autowired
    CovidRepository covidRepository;

    @Override
    public List<Sintoma> getAllSymptom() {
        return covidRepository.getListSymptom();
    }

    @Override
    public Sintoma getSymptomByName(String symptom) {
        return covidRepository.getListSymptom().stream().filter(s -> s.getNombre().equals(symptom)).findFirst().orElse(null);
    }
}
