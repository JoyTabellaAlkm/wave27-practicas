package ar.com.mercadolibre.showroom.repository;

import ar.com.mercadolibre.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findAllByTalle(String size);

    List<Prenda> findAllByNombreContainsIgnoreCase(String name);
}
