package com.mercadolibre.miniserieh2.repository;

import com.mercadolibre.miniserieh2.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

}
