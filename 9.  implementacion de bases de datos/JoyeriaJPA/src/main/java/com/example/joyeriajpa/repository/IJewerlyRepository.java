package com.example.joyeriajpa.repository;

import com.example.joyeriajpa.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewel,Integer> {
}
