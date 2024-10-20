package com.example.ejercicioijpa.controller;

import com.example.ejercicioijpa.model.Student;
import com.example.ejercicioijpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = studentService.getStudents();
        return students;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam ("name") String newName,
                               @RequestParam ("lastname") String newLastName) {
    Student student = studentService.findStudent(id);
    return student;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "El estudiante fue eliminado correctamente";
    }
}
