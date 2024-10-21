package com.mercadolibre.student.service;

import com.mercadolibre.student.model.Student;
import com.mercadolibre.student.model.dto.request.CreateStudentDTO;
import com.mercadolibre.student.model.dto.request.UpdateStudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    public Student getStudentById(Long id);

    public List<Student> getAllStudents();

    public void saveStudent(CreateStudentDTO studentDTO);

    public void updateStudent(UpdateStudentDTO studentDTO);

    public void deleteStudent(Long id);
}
