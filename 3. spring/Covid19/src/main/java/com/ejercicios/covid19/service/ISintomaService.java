package com.ejercicios.covid19.service;

import com.ejercicios.covid19.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    List<Sintoma> verSintomas();
   String consultarSintoma(String nombre);
}
