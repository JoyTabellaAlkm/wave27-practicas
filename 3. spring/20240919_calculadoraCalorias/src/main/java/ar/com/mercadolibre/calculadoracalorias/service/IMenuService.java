package ar.com.mercadolibre.calculadoracalorias.service;

import ar.com.mercadolibre.calculadoracalorias.dto.PlateDTO;
import ar.com.mercadolibre.calculadoracalorias.entity.Plate;

import java.util.List;

public interface IMenuService {

    List<Plate> findMenu();

    PlateDTO findPlate(String name, Integer weigth);
}
