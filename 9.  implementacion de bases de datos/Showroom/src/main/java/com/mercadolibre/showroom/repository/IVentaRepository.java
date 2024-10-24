package com.mercadolibre.showroom.repository;


import com.mercadolibre.showroom.entity.Venta;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findAllByFecha(LocalDate date);
}
