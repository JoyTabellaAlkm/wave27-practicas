package ar.org.mercadolibre.showroom.repository;

import ar.org.mercadolibre.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {

}
