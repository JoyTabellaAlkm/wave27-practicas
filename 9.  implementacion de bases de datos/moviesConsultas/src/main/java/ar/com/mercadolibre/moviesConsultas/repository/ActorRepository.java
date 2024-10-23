package ar.com.mercadolibre.moviesConsultas.repository;

import ar.com.mercadolibre.moviesConsultas.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a where a.favoriteMovieId IS NOT NULL")
    List<Actor> findByFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rate")
    List<Actor> findActorByRating(@Param("rate") Double rate);

    @Query("select a from Actor a join a.movies m where m.title = :title")
    List<Actor> findActorsByMovieTitle(@Param("title") String title);

}
