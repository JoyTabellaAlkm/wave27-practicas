package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    Long create(StudentDTO stu);
    StudentDTO read(Long id);
    Long update(StudentDTO stu);
    Boolean delete(Long id);
    Set<StudentDTO> getAll();
}
