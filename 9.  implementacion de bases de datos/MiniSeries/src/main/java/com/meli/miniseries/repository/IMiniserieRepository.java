package com.meli.miniseries.repository;

import com.meli.miniseries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {
}
