package org.mercadolibre.practica1configurandojpa.repository;

import org.mercadolibre.practica1configurandojpa.entity.MiniSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerieEntity, Long>{
}
