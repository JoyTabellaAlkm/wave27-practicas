package com.example.demo.repository;

import com.example.demo.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    Actor getFirstByFirstName(String name);
}
