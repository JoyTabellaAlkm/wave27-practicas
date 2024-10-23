package ar.com.mercadolibre.clothes.repository;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ISalesRepository extends ElasticsearchRepository<Sales, String> {
    Iterable<Sales> findClothesByDate(LocalDate date);
}
