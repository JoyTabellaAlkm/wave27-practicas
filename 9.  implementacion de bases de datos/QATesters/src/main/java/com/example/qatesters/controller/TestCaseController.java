package com.example.qatesters.controller;

import com.example.qatesters.dto.requestDto.TestCaseRequestDto;
import com.example.qatesters.service.impl.TestCaseServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {


    @Autowired
    TestCaseServices testCaseServices;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody @Valid TestCaseRequestDto testCaseRequestDto) {
        return new ResponseEntity<>(testCaseServices.createTestCase(testCaseRequestDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCases() {
        return new ResponseEntity<>(testCaseServices.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTestCasesForId(@PathVariable  Long id) {
        return new ResponseEntity<>(testCaseServices.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@RequestBody @Valid TestCaseRequestDto testCaseRequestDto, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseServices.updateTestCase(id,testCaseRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseServices.deleteTestCase(id), HttpStatus.OK);
    }
    @GetMapping("/lastupdate")
    public ResponseEntity<?> getAllByLastUpdateDateTestCase(@RequestParam String lastUpdateDate){
        return new ResponseEntity<>(testCaseServices.getAllByLastUpdateDateTestCase(lastUpdateDate), HttpStatus.OK);
    }


}
