package ar.com.mercadolibre.miniseries.repository;

import ar.com.mercadolibre.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
