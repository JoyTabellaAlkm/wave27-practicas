package com.meli.movies.repository;

import com.meli.movies.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query("SELECT e FROM Episode AS e INNER JOIN ActorEpisode AS ae ON  e.id = ae.episode.id WHERE e.id IN (SELECT ae.episode.id FROM ActorEpisode AS ae INNER JOIN Actor AS a ON ae.actor.id = a.id WHERE a.firstName LIKE :actorName ) ")
    List<Episode> findEpisodesByActorName(String actorName);
}
