package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.dto.request.SalesRequestDto;
import ar.com.mercadolibre.clothes.dto.response.ClothesResponseDto;
import ar.com.mercadolibre.clothes.dto.response.SalesResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {
    SalesResponseDto createSales(SalesRequestDto sale);

    List<SalesResponseDto> findAll();

    SalesResponseDto findSaleById(Long number);

    SalesResponseDto updateSale(Long number, SalesRequestDto sale);

    SalesResponseDto deleteSale(Long number);

    List<ClothesResponseDto> findByDate(LocalDate date);

    List<ClothesResponseDto> findAllClothes(Long number);

}
