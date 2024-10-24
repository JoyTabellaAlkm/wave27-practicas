package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.dto.request.ClothesRequestDto;
import ar.com.mercadolibre.clothes.dto.response.ClothesResponseDto;

import java.util.List;

public interface IClothesService {
    ClothesResponseDto createClothes(ClothesRequestDto clothes);

    List<ClothesResponseDto> findAll();

    ClothesResponseDto findClothes(Long code);

    ClothesResponseDto updateClothes(Long code, ClothesRequestDto clothes);

    ClothesResponseDto deleteClothes(Long code);

    List<ClothesResponseDto> findAllBySize(Double size);

    List<ClothesResponseDto> findAllByName(String name);
}
