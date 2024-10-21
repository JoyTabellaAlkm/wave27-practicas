package com.mercadolibre.crudjpa.service.impl;

import com.mercadolibre.crudjpa.dto.ResponseDTO;
import com.mercadolibre.crudjpa.entity.Student;
import com.mercadolibre.crudjpa.repository.IStudentRepository;
import com.mercadolibre.crudjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Student saveStudent(Student stu) {
        return repository.save(stu);
    }

    @Transactional
    @Override
    public ResponseDTO deleteStudent(long id) {
        repository.deleteById(id);
        return  new ResponseDTO("Estudiante eliminado con exito.");
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(long id, String newName,String newLastName) {
        Student stu = findStudent(id);
        stu.setName(newName);
        stu.setLastname(newLastName);
        return saveStudent(stu);
    }
}
