package com.bootcamp.qatesters.controller;

import com.bootcamp.qatesters.dto.CreateTestCaseDto;
import com.bootcamp.qatesters.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody CreateTestCaseDto testCaseDto) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseDto));
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCases(
            @RequestParam(required = false, name = "last_updated")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            String lastUpdated) {
        return ResponseEntity.ok(testCaseService.getAllTestCases(lastUpdated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody CreateTestCaseDto testCaseDto) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }
}
