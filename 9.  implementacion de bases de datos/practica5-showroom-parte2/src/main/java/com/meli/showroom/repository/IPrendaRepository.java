package com.meli.showroom.repository;


import com.meli.showroom.domain.Prenda;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findByNombreContaining(String name);

    List<Prenda> findAllByTalla(String size);
}
