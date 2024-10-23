package com.mercadolibre.clothes.service;

import com.mercadolibre.clothes.model.dto.request.ClothingRequestDTO;
import com.mercadolibre.clothes.model.dto.response.ClothingResponseDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;

import java.util.List;

public interface IClothingService {

    ClothingResponseDTO save(ClothingRequestDTO dto);
    List<ClothingResponseDTO> getAll();
    ClothingResponseDTO getById(Long code);
    ClothingResponseDTO update(Long code, ClothingRequestDTO dto);
    MessageResponse delete(Long code);
    List<ClothingResponseDTO> getBySize(String size);
    List<ClothingResponseDTO> getByNameContains(String name);
}
