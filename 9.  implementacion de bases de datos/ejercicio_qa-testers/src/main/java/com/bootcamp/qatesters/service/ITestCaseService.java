package com.bootcamp.qatesters.service;

import com.bootcamp.qatesters.dto.CreateTestCaseDto;
import com.bootcamp.qatesters.dto.CreatedTestCaseDto;
import com.bootcamp.qatesters.dto.TestCaseDto;
import com.bootcamp.qatesters.dto.UpdateTestCaseDto;

import java.util.List;

public interface ITestCaseService {
    CreatedTestCaseDto createTestCase(CreateTestCaseDto testCaseDto);

    List<TestCaseDto> getAllTestCases(String lastUpdated);

    TestCaseDto getTestCaseById(Long id);

    UpdateTestCaseDto updateTestCase(Long id, UpdateTestCaseDto testCaseDto);

    CreatedTestCaseDto deleteTestCase(Long id);
}
