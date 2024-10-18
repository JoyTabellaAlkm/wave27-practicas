package service;

import lombok.Data;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

@Service
@Data
public class StudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
