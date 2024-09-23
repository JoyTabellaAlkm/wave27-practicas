package co.mercadolibre.covid.service;

import co.mercadolibre.covid.entity.Sintoma;

import java.util.List;

public interface ISintomaService {
    public List<Sintoma> getAllSymptom();
    public Sintoma getSymptomByName(String nombre);
}
