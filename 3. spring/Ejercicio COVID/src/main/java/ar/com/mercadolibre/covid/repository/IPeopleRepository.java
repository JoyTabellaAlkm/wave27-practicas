package ar.com.mercadolibre.covid.repository;

import ar.com.mercadolibre.covid.entity.Person;

import java.util.List;

public interface IPeopleRepository {
    List<Person> findAll();
}
