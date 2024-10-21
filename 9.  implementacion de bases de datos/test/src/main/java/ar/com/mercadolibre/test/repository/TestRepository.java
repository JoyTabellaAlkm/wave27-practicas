package ar.com.mercadolibre.test.repository;

import ar.com.mercadolibre.test.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> getTestCasesByLastUpdateAfter(LocalDate date);
}
