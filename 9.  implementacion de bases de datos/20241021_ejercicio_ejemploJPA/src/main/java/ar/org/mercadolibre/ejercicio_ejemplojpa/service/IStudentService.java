package ar.org.mercadolibre.ejercicio_ejemplojpa.service;

import ar.org.mercadolibre.ejercicio_ejemplojpa.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(long id);
    public Student findStudent(long id);
    public void updateStudent(long id, String name, String lastname);
}
