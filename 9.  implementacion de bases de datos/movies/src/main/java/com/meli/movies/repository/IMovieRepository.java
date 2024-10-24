package com.meli.movies.repository;

import com.meli.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> movieActorsByRating(Double rating);

    List<Movie> moviesByGenre(String genreName);
}
