package com.example.ejercicioijpa.service;

import com.example.ejercicioijpa.model.Student;
import com.example.ejercicioijpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
        student.setName(student.getName());
        student.setLastName(student.getLastName());
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }
}
