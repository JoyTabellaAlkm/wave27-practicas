package ar.com.mercadolibre.movieshql.repository;

import ar.com.mercadolibre.movieshql.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeriesRepository extends JpaRepository<Series, Long> {
    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>

}
