package ar.org.mercadolibre.ejercicio_ejemplojpa.service;

import ar.org.mercadolibre.ejercicio_ejemplojpa.model.Student;
import ar.org.mercadolibre.ejercicio_ejemplojpa.repository.IStudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Student> getStudents() {
        return repository.findAll();
    }

    //guardar y actualizar
    @Override
    public void saveStudent(Student student) {
        repository.save(student);

    }

    @Override
    public void deleteStudent(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Student findStudent(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(long id, String name, String lastname) {
        Student stu= this.findStudent(id);
        stu.setName(name);
        stu.setLastname(lastname);
        this.saveStudent(stu);
    }

}
