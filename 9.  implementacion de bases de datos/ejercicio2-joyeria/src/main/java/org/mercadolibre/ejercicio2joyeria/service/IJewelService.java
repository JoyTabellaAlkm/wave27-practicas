package org.mercadolibre.ejercicio2joyeria.service;

import org.mercadolibre.ejercicio2joyeria.dto.request.JewelDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.JewelResponseDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.JewelUpdateDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.ResponseDTO;

import java.util.List;

public interface IJewelService {
    ResponseDTO createJewel(JewelDTO jewelDTO);

    List<JewelResponseDTO> getAllJewel();

    ResponseDTO deleteJewel(Long id);

    JewelUpdateDTO updateJewel(Long id, JewelDTO jewelDTO);
}
