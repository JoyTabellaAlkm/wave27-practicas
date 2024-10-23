package com.mercadolibre.clothes.service.impl;

import com.mercadolibre.clothes.exception.NotFoundException;
import com.mercadolibre.clothes.model.Clothing;
import com.mercadolibre.clothes.model.dto.request.ClothingRequestDTO;
import com.mercadolibre.clothes.model.dto.response.ClothingResponseDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import com.mercadolibre.clothes.repository.ClothingRepository;
import com.mercadolibre.clothes.service.IClothingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClothingService implements IClothingService {

    private final ClothingRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public ClothingResponseDTO save(ClothingRequestDTO dto){
        System.out.println(dto);
        Clothing toSave = modelMapper.map(dto, Clothing.class);
        System.out.println(toSave);
        return modelMapper.map(repository.save(toSave), ClothingResponseDTO.class);
    }

    @Override
    public List<ClothingResponseDTO> getAll(){
        return repository.findAll().stream()
                .map(clothing -> modelMapper.map(clothing, ClothingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClothingResponseDTO getById(Long code) {
        Clothing toSearch = repository.findById(code).orElseThrow(() -> new NotFoundException("There is no Clothing to delete with ID: " + code));
        return modelMapper.map(toSearch, ClothingResponseDTO.class);
    }

    @Override
    public ClothingResponseDTO update(Long code, ClothingRequestDTO dto) {
        Clothing toUpdate = modelMapper.map(dto, Clothing.class);
        toUpdate.setCode(code);
        return modelMapper.map(repository.save(toUpdate), ClothingResponseDTO.class);
    }

    @Override
    public MessageResponse delete(Long code) {
        Clothing toDelete = repository.findById(code).orElseThrow(() -> new NotFoundException("There is no Clothing to delete with ID: " + code));
        repository.delete(toDelete);
        return new MessageResponse("Deleted!");
    }

    @Override
    public List<ClothingResponseDTO> getBySize(String size) {
        List<Clothing> response = repository.getClothingBySizeEquals(size);

        return response.stream()
                .map(clothing -> modelMapper.map(clothing, ClothingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClothingResponseDTO> getByNameContains(String name) {
        List<Clothing> response = repository.getClothingByNameContainsIgnoreCase(name);

        return response.stream()
                .map(clothing -> modelMapper.map(clothing, ClothingResponseDTO.class))
                .collect(Collectors.toList());
    }
}
