package org.mercadolibre.practica2qatesters.service;

import org.mercadolibre.practica2qatesters.dto.request.TestCaseRequestDTO;
import org.mercadolibre.practica2qatesters.dto.response.ResponseDTO;
import org.mercadolibre.practica2qatesters.dto.response.TestCaseResponseDTO;
import org.mercadolibre.practica2qatesters.dto.response.UpdateTestCaseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResponseDTO createTestCase(TestCaseRequestDTO testCaseDTO);

    List<TestCaseResponseDTO> getAllTestCase();

    TestCaseResponseDTO getTestCaseById(Long id);

    UpdateTestCaseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO);

    ResponseDTO deleteTestCase(Long id);

    List<TestCaseResponseDTO> getTestCaseByDate(String date);
}
