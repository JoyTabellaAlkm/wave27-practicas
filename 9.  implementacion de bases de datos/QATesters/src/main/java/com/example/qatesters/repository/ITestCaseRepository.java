package com.example.qatesters.repository;

import com.example.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
  
   List<TestCase> findByLastUpdateAfter(LocalDate lastUpdateDate);
}
