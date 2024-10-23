package ar.com.mercadolibre.clothes.repository;

import ar.com.mercadolibre.clothes.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findAllBySize(Double size);

    List<Clothes> findAllByNameContainingIgnoreCase(String name);
}
