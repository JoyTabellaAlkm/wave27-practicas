package com.example.covidejercicio.services;

import com.example.covidejercicio.dto.PersonaSintomaDto;
import com.example.covidejercicio.modelo.Sintoma;

import java.util.List;

public interface ISintomaServices {
    List<Sintoma> obtenerSintomas();
    String obtenerNivelGravedadSiExiste(String nombre);
    List<PersonaSintomaDto> encontrarPersona();
}
