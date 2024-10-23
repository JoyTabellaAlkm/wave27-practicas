package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {
    Sales save(Sales sale);

    List<Sales> findAll();

    Sales findSaleById(String number);

    Sales updateSale(String number, Sales sale);

    String deleteSale(String number);

    List<Clothes> findByDate(LocalDate date);

    List<Clothes> findAllClothes(String number);

}
