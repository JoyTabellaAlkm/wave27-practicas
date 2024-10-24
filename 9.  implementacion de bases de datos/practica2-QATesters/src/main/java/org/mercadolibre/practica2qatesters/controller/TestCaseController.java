package org.mercadolibre.practica2qatesters.controller;

import org.mercadolibre.practica2qatesters.dto.request.TestCaseRequestDTO;
import org.mercadolibre.practica2qatesters.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService iTestCaseService;

    public TestCaseController(ITestCaseService iTestCaseService) {
        this.iTestCaseService = iTestCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseDTO){
        return new ResponseEntity<>(iTestCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCase(){
        return new ResponseEntity<>(iTestCaseService.getAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(iTestCaseService.updateTestCase(id, testCaseRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/last_update")
    ResponseEntity<?> getTestCaseByDate(@RequestParam(value = "last_update", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") String date){
        return new ResponseEntity<>(iTestCaseService.getTestCaseByDate(date), HttpStatus.OK);
    }
}
