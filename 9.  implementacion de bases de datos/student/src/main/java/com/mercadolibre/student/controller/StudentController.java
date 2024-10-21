package com.mercadolibre.student.controller;

import com.mercadolibre.student.model.Student;
import com.mercadolibre.student.model.dto.request.CreateStudentDTO;
import com.mercadolibre.student.model.dto.request.UpdateStudentDTO;
import com.mercadolibre.student.service.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService service;

    public StudentController(IStudentService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student response = service.getStudentById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> response = service.getAllStudents();
        return ResponseEntity.ok(response);
    }


    @PostMapping()
    public ResponseEntity<Void> createStudent(@RequestBody CreateStudentDTO studentDTO){
        service.saveStudent(studentDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateStudent(@RequestBody UpdateStudentDTO studentDTO){
        service.updateStudent(studentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }



}
