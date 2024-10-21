package com.mercadolibre.crudjpa.controller;

import com.mercadolibre.crudjpa.entity.Student;
import com.mercadolibre.crudjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody Student stu){
        
        return new ResponseEntity<>(studentService.saveStudent(stu), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestParam String newName, String newLastName){
        return new ResponseEntity<>(studentService.updateStudent(id,newName,newLastName), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        return  new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

}
