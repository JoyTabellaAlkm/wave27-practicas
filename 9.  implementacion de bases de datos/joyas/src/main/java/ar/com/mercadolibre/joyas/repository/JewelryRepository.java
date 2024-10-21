package ar.com.mercadolibre.joyas.repository;

import ar.com.mercadolibre.joyas.model.Jewelry;
import ar.com.mercadolibre.joyas.service.impl.JewelryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
}
