package com.meli.Ej_Estudiantes.repository;

import com.meli.Ej_Estudiantes.model.Student;
import org.hibernate.boot.model.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{

}
