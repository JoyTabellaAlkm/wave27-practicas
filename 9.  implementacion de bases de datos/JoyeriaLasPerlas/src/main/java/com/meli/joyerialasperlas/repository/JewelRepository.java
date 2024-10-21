package com.meli.joyerialasperlas.repository;

import com.meli.joyerialasperlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
