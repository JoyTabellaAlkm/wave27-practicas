package com.mercadoLibre.HQL.repository;

import com.mercadoLibre.HQL.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movies, Long> {
    @Query("SELECT m FROM Movies m WHERE (SELECT a.actor.rating FROM ActorMovie a WHERE a.movie.id = m.id) = :rating")
    List<Movies> findMoviesByActorsRating(@Param("rating") Double rating);

    @Query("SELECT m FROM Movies m WHERE m.genre.name = :genre")
    List<Movies> findByGenre(String genre);
}
