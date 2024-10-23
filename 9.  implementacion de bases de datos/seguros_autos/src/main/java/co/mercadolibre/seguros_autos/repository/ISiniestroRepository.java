package co.mercadolibre.seguros_autos.repository;

import co.mercadolibre.seguros_autos.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {

}
