package com.mercadolibre.qatester.repository;


import com.mercadolibre.qatester.enitity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT t FROM TestCase t WHERE t.lastUpdate >= :lastUpdate")
    List<TestCase> findTestCaseByLastUpdate(LocalDate lastUpdate);
}
