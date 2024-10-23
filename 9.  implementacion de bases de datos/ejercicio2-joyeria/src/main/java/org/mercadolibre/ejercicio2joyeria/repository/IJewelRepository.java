package org.mercadolibre.ejercicio2joyeria.repository;

import org.mercadolibre.ejercicio2joyeria.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
