package com.meli.showroom.repository;

import com.meli.showroom.domain.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface IVentaRepository extends ElasticsearchRepository<Venta, String> {
    List<Venta> findByFecha(String fecha);
}
