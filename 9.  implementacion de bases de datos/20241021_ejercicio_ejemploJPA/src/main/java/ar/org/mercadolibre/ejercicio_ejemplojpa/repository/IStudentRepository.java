package ar.org.mercadolibre.ejercicio_ejemplojpa.repository;

import ar.org.mercadolibre.ejercicio_ejemplojpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
