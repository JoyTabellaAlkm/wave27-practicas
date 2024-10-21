package com.mercadolibre.qatester.controller;

import com.mercadolibre.qatester.dto.request.TestCaseRequestDTO;
import com.mercadolibre.qatester.service.ITestCaseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService service;


    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(service.createTestCase(testCaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCase(@RequestParam(required = false) String lastUpdate){
        return new ResponseEntity<>(service.findAllTestCase(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIdTestCase(@PathVariable Long id){
        return new ResponseEntity<>(service.findByIdTestCase(id), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testUpdated){
        return new ResponseEntity<>(service.updateTestCase(id, testUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){

        return new ResponseEntity<>(service.deleteTestCase(id), HttpStatus.OK);
    }
}
