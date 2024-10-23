package com.mercadolibre.clothes.repository;

import com.mercadolibre.clothes.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> getSaleByDateEquals(LocalDate date);

    @Query("SELECT s FROM Sale s WHERE SIZE(s.clothing) = :number")
    List<Sale> findSalesByClothingNumber(@Param("number") Integer number);

}
