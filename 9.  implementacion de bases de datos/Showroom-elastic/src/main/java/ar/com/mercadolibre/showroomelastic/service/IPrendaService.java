package ar.com.mercadolibre.showroomelastic.service;

import ar.com.mercadolibre.showroomelastic.dto.CreateOkDTO;
import ar.com.mercadolibre.showroomelastic.dto.PrendaDTO;

import java.util.List;

public interface IPrendaService {

    CreateOkDTO createPrenda(PrendaDTO prenda);

    List<PrendaDTO> getAllPrendas();

    PrendaDTO getPrenda(Long codigo);

    CreateOkDTO updatePrenda(Long codigo, PrendaDTO prendaDTO);

    CreateOkDTO deletePrenda(Long codigo);

    List<PrendaDTO> getAllPrendasBySize(String size);

    List<PrendaDTO> getAllPrendasByName(String name);
}
