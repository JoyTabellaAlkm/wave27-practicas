package com.meli.showroom.repository;

import com.meli.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findByFecha(LocalDate fecha);
}
