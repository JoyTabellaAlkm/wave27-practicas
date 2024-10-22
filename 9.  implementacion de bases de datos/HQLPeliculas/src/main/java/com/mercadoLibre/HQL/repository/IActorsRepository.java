package com.mercadoLibre.HQL.repository;

import com.mercadoLibre.HQL.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorsRepository extends JpaRepository<Actors, Long> {
    @Query("SELECT a FROM Actors a WHERE a.favoriteMovie IS NOT NULL")
    List<Actors> findActorsWithNotNullFavoriteMovie();

    @Query("SELECT a FROM Actors a WHERE a.rating > :rating")
    List<Actors> findActorsOverRating(@Param("rating") Double rating);

    @Query(nativeQuery = true, value = "SELECT a.actors FROM Movies a WHERE a.title = :title")
    List<Actors> findActorsByMovieTitle(@Param("title") String title);
}
