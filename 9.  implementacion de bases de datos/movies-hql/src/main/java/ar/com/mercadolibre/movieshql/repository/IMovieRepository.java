package ar.com.mercadolibre.movieshql.repository;

import ar.com.mercadolibre.movieshql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    //Listar todas las películas cuyos actores tengan un rating superior a <valor recibido por parámetro>
}
