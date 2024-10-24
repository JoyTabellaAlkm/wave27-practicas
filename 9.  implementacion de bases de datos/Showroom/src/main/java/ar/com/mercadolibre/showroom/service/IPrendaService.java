package ar.com.mercadolibre.showroom.service;

import ar.com.mercadolibre.showroom.dto.CreateOkDTO;
import ar.com.mercadolibre.showroom.dto.PrendaDTO;

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
