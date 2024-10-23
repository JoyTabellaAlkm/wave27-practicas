package com.meli.showroom.repository;

import com.meli.showroom.dto.PrendaResponseDto;
import com.meli.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByNombreContaining(String name);

    List<Prenda> findAllByTalla(String size);
}
