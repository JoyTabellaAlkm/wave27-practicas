package ar.com.mercadolibre.showroomelastic.repository;

import ar.com.mercadolibre.showroomelastic.entity.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends ElasticsearchRepository<Venta, Long> {
    List<Venta> findAllByFecha(LocalDate date);
}
