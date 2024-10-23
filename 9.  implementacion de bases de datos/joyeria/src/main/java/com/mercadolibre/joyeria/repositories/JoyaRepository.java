package com.mercadolibre.joyeria.repositories;

import com.mercadolibre.joyeria.entities.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Integer> {
}
