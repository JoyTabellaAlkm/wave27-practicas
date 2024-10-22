package ar.org.mercadolibre.ejercicio_ejemplojpa.controller;

import ar.org.mercadolibre.ejercicio_ejemplojpa.model.Student;
import ar.org.mercadolibre.ejercicio_ejemplojpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {

    @Autowired
    private IStudentService studentService;


    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("El estudiante fue agregado correctamente", HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam("name") String name,
                               @RequestParam("lastname") String lastName){
        studentService.updateStudent(id,name,lastName);
        return studentService.findStudent(id);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("El estudiante fue borrado correctamente", HttpStatus.OK);
    }

}
