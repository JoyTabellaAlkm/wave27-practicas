package com.meli.movies.repository;

import com.meli.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    List<Serie> seriesByNumberOfSeasons(Integer numberOfSeasons);
}
