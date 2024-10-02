package com.edad.Clase14_Deportistas.service;

import com.edad.Clase14_Deportistas.dto.DeporteDto;
import com.edad.Clase14_Deportistas.dto.DeportistaDto;

import java.util.List;

public interface IDeportistasService {
    List<DeporteDto> findSports();
    List<DeporteDto> findSportByName(String name);
    List<DeportistaDto> findSportPeople();
}
