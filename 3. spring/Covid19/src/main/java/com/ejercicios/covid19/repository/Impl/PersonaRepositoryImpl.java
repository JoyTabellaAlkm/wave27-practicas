package com.ejercicios.covid19.repository.Impl;

import com.ejercicios.covid19.model.Persona;
import com.ejercicios.covid19.model.Sintoma;
import com.ejercicios.covid19.repository.IPersonaRepository;
import com.ejercicios.covid19.repository.ISintomaRepository;
import com.ejercicios.covid19.service.Impl.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
    List<Persona> listaPersonas = new ArrayList<>();

    @Autowired
    ISintomaRepository sintomaRepository;

    public PersonaRepositoryImpl() {
        List<Sintoma> listaSintomas = new ArrayList<>();
        listaSintomas.add(sintomaRepository.verSintomas().get(0));
    listaPersonas.add(new Persona(1L,"Luis","Rodriguez", 67, listaSintomas));
    }

    @Override
    public List<Persona> verPersonas() {
return listaPersonas;
    }
}
