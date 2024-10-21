package ar.com.mercadolibre.crudstudent.controller;

import ar.com.mercadolibre.crudstudent.model.Student;
import ar.com.mercadolibre.crudstudent.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Estudiante creado con exito";
    }

    @GetMapping ("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id,
                      @RequestParam ("name") String newName,
                       @RequestParam ("lastName") String newLastName){
        Student student = studentService.findStudent(id);
        student.setName(newName);
        student.setLastName(newLastName);
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Estudiante borrado correctamente";
    }
}
