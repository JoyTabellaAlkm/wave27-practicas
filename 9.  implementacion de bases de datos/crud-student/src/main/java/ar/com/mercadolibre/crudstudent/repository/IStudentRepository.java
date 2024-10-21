package ar.com.mercadolibre.crudstudent.repository;

import ar.com.mercadolibre.crudstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
