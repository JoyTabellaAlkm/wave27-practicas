package com.meli.movies.repository;

import com.meli.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findActorsByFavoriteMovieIdIsNotNull();

//    @Query("SELECT a FROM Actor AS a WHERE a.rating > :rating ")
    List<Actor> findActorsByRatingGreaterThan(@Param("rating") double rating);

    @Query("SELECT a FROM Actor AS a INNER JOIN ActorMovie AS am ON  a.id = am.actor.id WHERE a.id IN (SELECT am.actor.id FROM ActorMovie AS am INNER JOIN Movie AS m ON am.movie.id = m.id WHERE m.title LIKE :movieName ) ")
    List<Actor> findActorsByMovie(@Param("movieName") String movieName);
}
