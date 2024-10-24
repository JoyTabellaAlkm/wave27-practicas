package ar.org.mercadolibre.showroom.service;

import ar.org.mercadolibre.showroom.dto.ClothingDTO;
import ar.org.mercadolibre.showroom.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> getAllSales();
    SaleDTO getSaleByNumber(Long number);
    SaleDTO updateSaleByNumber(Long number,SaleDTO saleDTO);
    String deleteSale(Long number);
   // List<ClothingDTO> getAllsClothingBySaleDate(LocalDate date);

   // List<ClothingDTO> getClothingsBySaleNumber(Long number);
}
