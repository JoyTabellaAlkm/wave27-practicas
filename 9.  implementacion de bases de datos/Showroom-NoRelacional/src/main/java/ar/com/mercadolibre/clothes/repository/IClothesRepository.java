package ar.com.mercadolibre.clothes.repository;

import ar.com.mercadolibre.clothes.entity.Clothes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends ElasticsearchRepository<Clothes, String> {
    List<Clothes> findAllBySize(String size);

    List<Clothes> findAllByNameContainingIgnoreCase(String name);
}
