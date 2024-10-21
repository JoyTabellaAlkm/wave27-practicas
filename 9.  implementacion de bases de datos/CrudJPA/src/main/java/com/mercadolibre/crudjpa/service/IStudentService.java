package com.mercadolibre.crudjpa.service;

import com.mercadolibre.crudjpa.dto.ResponseDTO;
import com.mercadolibre.crudjpa.entity.Student;

import java.util.List;

public interface IStudentService {
     List<Student> getStudents();
     Student saveStudent (Student stu);
     ResponseDTO deleteStudent(long id);
      Student findStudent(long id);
      Student updateStudent(long id, String newName,String newLastName);
}
