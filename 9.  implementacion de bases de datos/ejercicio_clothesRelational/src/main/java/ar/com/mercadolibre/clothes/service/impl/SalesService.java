package ar.com.mercadolibre.clothes.service.impl;

import ar.com.mercadolibre.clothes.dto.request.SalesRequestDto;
import ar.com.mercadolibre.clothes.dto.response.ClothesResponseDto;
import ar.com.mercadolibre.clothes.dto.response.SalesResponseDto;
import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;
import ar.com.mercadolibre.clothes.exception.NotFoundException;
import ar.com.mercadolibre.clothes.repository.ISalesRepository;
import ar.com.mercadolibre.clothes.service.ISalesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService implements ISalesService {
    private final ISalesRepository salesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SalesService(ISalesRepository salesRepository) {
        this.salesRepository = salesRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public SalesResponseDto createSales(SalesRequestDto sale) {
        Sales salesEntity = modelMapper.map(sale, Sales.class);
        return modelMapper.map(salesRepository.save(salesEntity), SalesResponseDto.class);
    }

    @Override
    public List<SalesResponseDto> findAll() {
        List<Sales> sales = salesRepository.findAll();
        return sales.stream()
                .map(s -> modelMapper.map(s, SalesResponseDto.class))
                .toList();
    }

    @Override
    public SalesResponseDto findSaleById(Long number) {
        Sales sale = salesRepository.findById(number).orElseThrow(() -> new NotFoundException("Sales not found with code: " + number));
        return modelMapper.map(sale, SalesResponseDto.class);
    }

    @Override
    public SalesResponseDto updateSale(Long number, SalesRequestDto updatedSale) {
        Sales existingSale = salesRepository.findById(number)
                .orElseThrow(() -> new NotFoundException("Sales not found with code: " + number));
        modelMapper.map(updatedSale, existingSale);
        Sales savedSales = salesRepository.save(existingSale);
        return modelMapper.map(savedSales, SalesResponseDto.class);
    }

    @Override
    public SalesResponseDto deleteSale(Long number) {
        Sales existingSale = salesRepository.findById(number)
                .orElseThrow(() -> new NotFoundException("Sales not found with code: " + number));
        SalesResponseDto salesResponseDto = modelMapper.map(existingSale, SalesResponseDto.class);
        salesRepository.delete(existingSale);
        return salesResponseDto;
    }

    @Override
    public List<ClothesResponseDto> findByDate(LocalDate date) {
        List<Clothes> clothes = salesRepository.findAllClothesByDate(date);
        return clothes.stream()
                .map(c -> modelMapper.map(c, ClothesResponseDto.class))
                .toList();
    }

    @Override
    public List<ClothesResponseDto> findAllClothes(Long number) {
        List<Clothes> clothes = salesRepository.findAllClothesFromSale(number);
        return clothes.stream()
                .map(c -> modelMapper.map(c, ClothesResponseDto.class))
                .toList();
    }
}
