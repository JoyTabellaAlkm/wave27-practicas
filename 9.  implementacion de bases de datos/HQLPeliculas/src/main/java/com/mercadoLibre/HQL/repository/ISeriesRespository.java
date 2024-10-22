package com.mercadoLibre.HQL.repository;

import com.mercadoLibre.HQL.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesRespository extends JpaRepository<Series, Long> {

    @Query("SELECT s FROM Series s WHERE COUNT(s.seasons) > :seasons")
    List<Series> findSeriesBySeasons(@Param("seasons") Integer seasons);
}
