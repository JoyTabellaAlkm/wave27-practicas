package ar.com.mercadolibre.crudstudent.service;


import ar.com.mercadolibre.crudstudent.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(Long id);
    public Student findStudent(Long id);
}
