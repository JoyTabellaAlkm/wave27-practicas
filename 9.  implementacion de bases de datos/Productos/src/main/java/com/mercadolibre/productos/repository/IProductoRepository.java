package com.mercadolibre.productos.repository;

import com.mercadolibre.productos.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {

}
