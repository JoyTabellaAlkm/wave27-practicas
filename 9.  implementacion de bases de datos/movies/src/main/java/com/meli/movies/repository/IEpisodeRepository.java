package com.meli.movies.repository;

import com.meli.movies.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
    //@Query(" ")
    List<Episode> episodeByActor(String actorName);
}
