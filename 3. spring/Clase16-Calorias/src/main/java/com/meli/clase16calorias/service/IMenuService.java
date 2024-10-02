package com.meli.clase16calorias.service;

import com.meli.clase16calorias.dto.PlatoDTO;
import com.meli.clase16calorias.dto.PlatoEstandarDTO;
import com.meli.clase16calorias.model.Plato;

import java.util.List;

public interface IMenuService {

    List<PlatoEstandarDTO> showMenu();
    PlatoDTO showPlateByWeight(String name, int weight);
}
