package com.mercadoLibre.QATesters.controller;

import com.mercadoLibre.QATesters.dto.ResponseDTO;
import com.mercadoLibre.QATesters.dto.TestCaseRequestDTO;
import com.mercadoLibre.QATesters.dto.TestCaseResponseDTO;
import com.mercadoLibre.QATesters.service.ITestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping(value = "/new")
    public ResponseEntity<TestCaseResponseDTO> createTestCase(@RequestBody @Valid TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases() {
        return ResponseEntity.ok(testCaseService.getTestCases());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateTestCase(@PathVariable Long id, @RequestBody @Valid TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.updateTestCase(testCaseRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCasesAfterDate(@RequestParam(name = "last_update") String date) {
        return ResponseEntity.ok(testCaseService.getTestCasesByDate(date));
    }
}
