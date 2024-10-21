package com.mercadolibre.joyeria.repository;

import com.mercadolibre.joyeria.enitity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
