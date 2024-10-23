package org.mercadolibre.ejercicio1h2.repository;

import org.mercadolibre.ejercicio1h2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
