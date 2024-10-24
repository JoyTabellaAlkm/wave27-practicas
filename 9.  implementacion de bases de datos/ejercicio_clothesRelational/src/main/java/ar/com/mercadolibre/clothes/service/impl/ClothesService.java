package ar.com.mercadolibre.clothes.service.impl;

import ar.com.mercadolibre.clothes.dto.request.ClothesRequestDto;
import ar.com.mercadolibre.clothes.dto.response.ClothesResponseDto;
import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.exception.NotFoundException;
import ar.com.mercadolibre.clothes.repository.IClothesRepository;
import ar.com.mercadolibre.clothes.service.IClothesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService {
    private final IClothesRepository clothesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClothesService(IClothesRepository clothesRepository, ModelMapper modelMapper) {
        this.clothesRepository = clothesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClothesResponseDto createClothes(ClothesRequestDto clothes) {
        Clothes clothesEntity = modelMapper.map(clothes, Clothes.class);
        return modelMapper.map(clothesRepository.save(clothesEntity), ClothesResponseDto.class);
    }

    @Override
    public List<ClothesResponseDto> findAll() {
        List<Clothes> clothes = clothesRepository.findAll();
        return clothes.stream()
                .map(c -> modelMapper.map(c, ClothesResponseDto.class))
                .toList();
    }

    @Override
    public ClothesResponseDto findClothes(Long code) {
        Clothes clothes = clothesRepository.findById(code).orElseThrow(() -> new NotFoundException("Clothes not found with code: " + code));
        return modelMapper.map(clothes, ClothesResponseDto.class);
    }

    @Override
    public ClothesResponseDto updateClothes(Long code, ClothesRequestDto updatedClothes) {
        Clothes existingClothes = clothesRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Clothes not found with code: " + code));
        modelMapper.map(updatedClothes, existingClothes);
        Clothes savedClothes = clothesRepository.save(existingClothes);
        return modelMapper.map(savedClothes, ClothesResponseDto.class);
    }


    @Override
    public ClothesResponseDto deleteClothes(Long code) {
        Clothes existingClothes = clothesRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Clothes not found with code: " + code));
        ClothesResponseDto clothesResponseDto = modelMapper.map(existingClothes, ClothesResponseDto.class);
        clothesRepository.delete(existingClothes);
        return clothesResponseDto;
    }

    @Override
    public List<ClothesResponseDto> findAllBySize(Double size) {
        List<Clothes> clothes = clothesRepository.findAllBySize(size);
        return clothes.stream()
                .map(c -> modelMapper.map(c, ClothesResponseDto.class))
                .toList();
    }

    @Override
    public List<ClothesResponseDto> findAllByName(String name) {
        List<Clothes> clothes = clothesRepository.findAllByNameContainingIgnoreCase(name);
        return clothes.stream()
                .map(c -> modelMapper.map(c, ClothesResponseDto.class))
                .toList();
    }
}
