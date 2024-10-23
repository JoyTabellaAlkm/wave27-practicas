package com.mercadolibre.clothes.service;


import com.mercadolibre.clothes.model.dto.request.SaleRequestDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import com.mercadolibre.clothes.model.dto.response.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleResponseDTO save(SaleRequestDTO dto);

    List<SaleResponseDTO> getAll();

    SaleResponseDTO getSaleByCode(Long code);

    MessageResponse delete(Long code);

    List<SaleResponseDTO> getByDate(LocalDate date);

    List<SaleResponseDTO> getByClothesNumber(Integer number);
}
