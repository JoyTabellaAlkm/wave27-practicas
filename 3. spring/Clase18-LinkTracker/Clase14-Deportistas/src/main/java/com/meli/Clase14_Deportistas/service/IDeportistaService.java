package com.meli.Clase14_Deportistas.service;

import com.meli.Clase14_Deportistas.dto.DeporteDTO;
import com.meli.Clase14_Deportistas.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistaService {
    public List<DeporteDTO> findAllSports();
    public DeporteDTO findSport(String nombre);
    public List<DeportistaDTO> findSportsPeople();
}
