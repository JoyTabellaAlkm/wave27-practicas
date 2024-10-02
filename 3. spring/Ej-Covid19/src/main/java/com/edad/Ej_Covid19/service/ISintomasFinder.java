package com.edad.Ej_Covid19.service;

import com.edad.Ej_Covid19.dto.PersonaDTO;
import com.edad.Ej_Covid19.modelo.Sintoma;

import java.util.List;

public interface ISintomasFinder {

    List<Sintoma> showAllSymptoms();

    String checkSymptom(String name);

    List<PersonaDTO> getRiskPerson();
}
