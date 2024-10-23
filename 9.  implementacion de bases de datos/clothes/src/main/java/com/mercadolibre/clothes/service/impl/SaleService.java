package com.mercadolibre.clothes.service.impl;

import com.mercadolibre.clothes.exception.NotFoundException;
import com.mercadolibre.clothes.model.Clothing;
import com.mercadolibre.clothes.model.Sale;
import com.mercadolibre.clothes.model.dto.request.SaleRequestDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import com.mercadolibre.clothes.model.dto.response.SaleResponseDTO;
import com.mercadolibre.clothes.repository.ClothingRepository;
import com.mercadolibre.clothes.repository.SaleRepository;
import com.mercadolibre.clothes.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final SaleRepository repository;
    private final ClothingRepository clothingRepository;
    private final ModelMapper modelMapper;


    @Override
    public SaleResponseDTO save(SaleRequestDTO dto) {
        Sale sale = modelMapper.map(dto, Sale.class);
        List<Clothing> clothingList = dto.getClothing().stream()
                .map(clothingId -> clothingRepository.findById(clothingId)
                        .orElseThrow(() -> new RuntimeException("Clothing not found: " + clothingId)))
                .collect(Collectors.toList());
        clothingList.forEach(clothing -> clothing.setSale(sale));
        Sale savedSale = repository.save(sale);
        return modelMapper.map(savedSale, SaleResponseDTO.class);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(sale -> modelMapper.map(sale, SaleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleResponseDTO getSaleByCode(Long code) {
        return modelMapper.map(repository.findById(code), SaleResponseDTO.class);
    }

    @Override
    public MessageResponse delete(Long code) {
        Sale toDelete = repository.findById(code).orElseThrow(() -> new NotFoundException("There is no sale with that ID"));
        repository.delete(toDelete);
        return new MessageResponse("Deleted!");
    }

    @Override
    public List<SaleResponseDTO> getByDate(LocalDate date) {
        List<Sale> response = repository.getSaleByDateEquals(date);
        return response.stream().map(sale -> modelMapper.map(sale, SaleResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<SaleResponseDTO> getByClothesNumber(Integer number) {
        List<Sale> response = repository.findSalesByClothingNumber(number);

        return response.stream().map(sale -> modelMapper.map(sale, SaleResponseDTO.class))
                .collect(Collectors.toList());
    }
}
