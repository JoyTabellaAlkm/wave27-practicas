package ar.com.mercadolibre.showroom.repository;

import ar.com.mercadolibre.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findAllByFecha(LocalDate date);
}
