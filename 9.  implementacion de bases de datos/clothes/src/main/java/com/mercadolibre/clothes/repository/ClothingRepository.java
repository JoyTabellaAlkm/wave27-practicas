package com.mercadolibre.clothes.repository;

import com.mercadolibre.clothes.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {

    List<Clothing> getClothingBySizeEquals(String size);

    List<Clothing> getClothingByNameContainsIgnoreCase(String name);
}
