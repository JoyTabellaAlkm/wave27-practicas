package ar.com.mercadolibre.joyas.service;

import ar.com.mercadolibre.joyas.model.Jewelry;
import ar.com.mercadolibre.joyas.model.dto.request.CreateJewelryDTO;
import ar.com.mercadolibre.joyas.model.dto.request.UpdateJewelryDTO;

import java.util.List;

public interface IJewelryService {

    Long createJewelry(CreateJewelryDTO jewelryDTO);

    List<Jewelry> getAllJewelry();

    void deleteJewelry(Long id);

    Jewelry updateJewelry(Long id, UpdateJewelryDTO jewelryDTO);
}
