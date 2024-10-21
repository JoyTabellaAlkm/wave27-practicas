package com.mercadolibre.qatester.service;

import com.mercadolibre.qatester.dto.ResponseDTO;
import com.mercadolibre.qatester.dto.request.TestCaseRequestDTO;
import com.mercadolibre.qatester.dto.response.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    List<TestCaseResponseDTO> findAllTestCase(String lastUpdate);
    TestCaseResponseDTO findByIdTestCase(Long id);
    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testUpdated);
    ResponseDTO deleteTestCase(Long id);

}
