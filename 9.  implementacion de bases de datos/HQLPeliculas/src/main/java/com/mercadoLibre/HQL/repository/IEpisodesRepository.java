package com.mercadoLibre.HQL.repository;

import com.mercadoLibre.HQL.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEpisodesRepository extends JpaRepository<Episodes, Long> {

    @Query("SELECT e FROM Episodes e INNER JOIN e.actors a WHERE a.actor.firstName = :actorName AND a.actor.lastName = :actorLastName")
    List<Episodes> findByActors(String actorName, String actorLastName);
}
