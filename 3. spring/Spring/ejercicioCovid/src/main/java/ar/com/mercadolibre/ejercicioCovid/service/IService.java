package ar.com.mercadolibre.ejercicioCovid.service;

import ar.com.mercadolibre.ejercicioCovid.entitys.Sintoma;

import java.util.List;

public interface IService {
    List<Sintoma> findBySymptom();
    String findSimptomByName(String name);
    String findRiskPerson();
}
