package com.meli.movies.repository;

import com.meli.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT DISTINCT m FROM Movie AS m INNER JOIN ActorMovie AS am ON  m.id = am.movie.id WHERE m.id NOT IN (SELECT am.movie.id FROM ActorMovie AS am INNER JOIN Actor AS a ON am.actor.id = a.id WHERE a.rating <= :rating ) ")
    List<Movie> findMoviesByActorsRating(Double rating);

    @Query("SELECT m FROM Movie AS m INNER JOIN Genre as g ON m.genreId = g.id WHERE g.name = :genreName")
    List<Movie> findMoviesByGenreName(String genreName);
}
