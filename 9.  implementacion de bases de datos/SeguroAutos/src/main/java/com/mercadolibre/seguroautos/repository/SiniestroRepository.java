package com.mercadolibre.seguroautos.repository;

import com.mercadolibre.seguroautos.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiniestroRepository extends JpaRepository<Siniestro,Long> {
}
