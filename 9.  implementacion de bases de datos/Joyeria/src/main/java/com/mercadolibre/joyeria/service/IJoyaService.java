package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.request.JoyaRequestDto;
import com.mercadolibre.joyeria.dto.response.IdJoyaResponseDTO;
import com.mercadolibre.joyeria.dto.response.JoyaResponseDTO;
import com.mercadolibre.joyeria.dto.response.ResponseDTO;

import java.util.List;

public interface IJoyaService {
    IdJoyaResponseDTO createJoya(JoyaRequestDto joyaDto);
    List<JoyaResponseDTO> getAll();
    ResponseDTO deleteJoya(Long id);
    JoyaResponseDTO updateJoya(Long id, JoyaRequestDto joyaDto);

}
