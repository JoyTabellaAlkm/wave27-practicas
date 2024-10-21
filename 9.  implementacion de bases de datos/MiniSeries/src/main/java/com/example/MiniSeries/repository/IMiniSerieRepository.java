package com.example.MiniSeries.repository;

import com.example.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
    //List<MiniSerie> findMiniSeries ();
    //void saveMiniSerie (MiniSerie miniSerie);
}
