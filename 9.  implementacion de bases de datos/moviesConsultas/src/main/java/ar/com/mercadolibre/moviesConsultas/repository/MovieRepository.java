package ar.com.mercadolibre.moviesConsultas.repository;

import ar.com.mercadolibre.moviesConsultas.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> getMovieByActorRating(@Param("rating") Double rating);

    @Query("select m from Movie m where m.genreId = :genre")
    List<Movie> getMovieByGenreId(@Param("genre") Integer genre);

}
