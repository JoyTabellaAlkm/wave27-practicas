package com.meli.movies.repository;

import com.meli.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT a FROM Actor AS a WHERE a.favoriteMovieId IS NOT Null ")
    List<Actor> listActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor AS a WHERE a.rating > :rating ")
    List<Actor> listActorsByRating(@Param("rating") double rating);

//    @Query("SELECT a FROM Actor AS a INNER JOIN Movie AS m ON  ")
    List<Actor> listActorsByMovie(@Param("movieName") String movieName);
}
