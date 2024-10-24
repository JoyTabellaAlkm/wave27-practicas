package ar.org.mercadolibre.showroom.repository;

import ar.org.mercadolibre.showroom.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;



@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> findClothingBySize(String size);
    List<Clothing> findClothingByNameContainingIgnoreCase(String clothingName);
    List<Clothing> findAllBySales_id(Long number);

    @Query("select c.name from Clothing c Join Sale s where s.date = :date ")
    List<Clothing> findClothingBySalesDate(@Param("date") LocalDate date);
}
