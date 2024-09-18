package com.ejercicios.covid19.repository.Impl;

import com.ejercicios.covid19.model.Sintoma;
import com.ejercicios.covid19.repository.ISintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepositoryImpl implements ISintomaRepository {

 private  List<Sintoma> listaSintomas = new ArrayList<>();

    public SintomaRepositoryImpl() {
        listaSintomas.add( new Sintoma(1L,"Fiebre","Alto"));
        listaSintomas.add(new Sintoma(2L,"Tos","Medio"));
        listaSintomas.add(new Sintoma(3L,"Perdida del gusto","Bajo"));
    }

    public List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<Sintoma> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }

    @Override
    public List<Sintoma> verSintomas() {
        return listaSintomas;
    }
}
