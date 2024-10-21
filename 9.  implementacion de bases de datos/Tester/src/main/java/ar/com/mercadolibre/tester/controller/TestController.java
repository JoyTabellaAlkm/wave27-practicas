package ar.com.mercadolibre.tester.controller;

import ar.com.mercadolibre.tester.entity.TestCase;
import ar.com.mercadolibre.tester.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private ITestService testService;

    @PostMapping("/testcases/new")
    public ResponseEntity<?> createTest(@RequestBody TestCase testCase){
        return new ResponseEntity<>(testService.createTest(testCase), HttpStatus.CREATED);
    }

    @GetMapping("/testcases/all")
    public ResponseEntity<?> getAllTest(){
        return new ResponseEntity<>(testService.getAllTest(), HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<?> getTest(@PathVariable Long id){
        return new ResponseEntity<>(testService.getTest(id), HttpStatus.OK);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> updateTest(@PathVariable Long id,
                                        @RequestParam String descripcion,
                                        @RequestParam Boolean tested,
                                        @RequestParam Boolean passed,
                                        @RequestParam int numberOfTries,
                                        @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        TestCase testCase = testService.findById(id);
        testCase.setDescripcion(descripcion);
        testCase.setTested(tested);
        testCase.setPassed(passed);
        testCase.setNumberOfTries(numberOfTries);
        testCase.setLastUpdate(lastUpdate);
        return new ResponseEntity<>(testService.updateTest(testCase), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id){
        return new ResponseEntity<>(testService.deleteTest(id), HttpStatus.OK);
    }

    @GetMapping("/testcases")
    public ResponseEntity<?> getAllTestDate(@RequestParam ("last_update")
                                                @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return new ResponseEntity<>(testService.getAllTestDate(lastUpdate), HttpStatus.OK);
    }

}
