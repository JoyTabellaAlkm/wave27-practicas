package ar.com.mercadolibre.empresaseguros.repository;

import ar.com.mercadolibre.empresaseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
