package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> findAll();
}
