package com.example.qatesters.service;

import com.example.qatesters.dto.requestDto.TestCaseRequestDto;
import com.example.qatesters.dto.responseDTO.TestCaseResponseDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ITestCaseServices {

    TestCaseResponseDto createTestCase(TestCaseRequestDto testCaseRequestDto);
    List<TestCaseResponseDto> getAllTestCases();
    TestCaseResponseDto getTestCaseById(Long id);
    TestCaseResponseDto updateTestCase(Long id, TestCaseRequestDto testCaseRequestDto);
    TestCaseResponseDto deleteTestCase(Long id);
    List<TestCaseResponseDto> getAllByLastUpdateDateTestCase(String lastUpdateTestCase);
}
