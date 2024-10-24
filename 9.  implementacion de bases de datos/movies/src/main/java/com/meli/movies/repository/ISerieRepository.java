package com.meli.movies.repository;

import com.meli.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("SELECT sr FROM Serie AS sr INNER JOIN Season AS ss ON sr.id = ss.serieId GROUP BY ss.serieId HAVING COUNT(*) > :numberOfSeasons")
    List<Serie> findSerieByNumberOfSeasons(Integer numberOfSeasons);
}
