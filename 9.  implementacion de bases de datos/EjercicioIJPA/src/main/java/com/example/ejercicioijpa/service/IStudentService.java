package com.example.ejercicioijpa.service;

import com.example.ejercicioijpa.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}
