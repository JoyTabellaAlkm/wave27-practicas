package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JewelRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findAllByVentaONoIsTrue();
}
