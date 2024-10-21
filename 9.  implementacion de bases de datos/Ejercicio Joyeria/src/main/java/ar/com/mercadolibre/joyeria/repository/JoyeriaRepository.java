package ar.com.mercadolibre.joyeria.repository;

import ar.com.mercadolibre.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyeriaRepository extends JpaRepository <Joya, Long> {
}
