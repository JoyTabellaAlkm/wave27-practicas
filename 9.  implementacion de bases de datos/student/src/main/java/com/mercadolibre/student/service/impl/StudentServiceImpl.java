package com.mercadolibre.student.service.impl;

import com.mercadolibre.student.model.Student;
import com.mercadolibre.student.model.dto.request.CreateStudentDTO;
import com.mercadolibre.student.model.dto.request.UpdateStudentDTO;
import com.mercadolibre.student.repository.IStudentRepository;
import com.mercadolibre.student.service.IStudentService;
import com.mercadolibre.student.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository repository){
        this.studentRepository = repository;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(CreateStudentDTO studentDTO) {
        Student student = Util.changeDtoToEntity(studentDTO, Student.class);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(UpdateStudentDTO studentDTO) {
        Student student = Util.changeDtoToEntity(studentDTO, Student.class);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}
