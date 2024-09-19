package ar.com.mercadolibre.dto.sportman.service;

import ar.com.mercadolibre.dto.sportman.model.Sport;
import ar.com.mercadolibre.dto.sportman.model.SportmanDTO;

import java.util.List;

public interface ISportmanService {

    List<Sport> getSportList();

    Sport getSport(String name);

    List<SportmanDTO> getSportmanList();
}
