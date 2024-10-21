package com.mercadoLibre.QATesters.service;

import com.mercadoLibre.QATesters.dto.ResponseDTO;
import com.mercadoLibre.QATesters.dto.TestCaseRequestDTO;
import com.mercadoLibre.QATesters.dto.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    List<TestCaseResponseDTO> getTestCases();
    TestCaseResponseDTO getTestCaseById(Long id);
    ResponseDTO updateTestCase(TestCaseRequestDTO testCaseRequestDTO, Long id);
    ResponseDTO deleteTestCase(Long id);
    List<TestCaseResponseDTO> getTestCasesByDate(String date);
}
