package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {
    Sales save(Sales sale);

    List<Sales> findAll();

    Sales findSaleById(Long number);

    Sales updateSale(Long number, Sales sale);

    String deleteSale(Long number);

    List<Clothes> findByDate(LocalDate date);

    List<Clothes> findAllClothes(Long number);

}
