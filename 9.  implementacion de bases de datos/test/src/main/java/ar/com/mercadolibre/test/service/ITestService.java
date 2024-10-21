package ar.com.mercadolibre.test.service;

import ar.com.mercadolibre.test.model.TestCase;
import ar.com.mercadolibre.test.model.dto.request.TestCaseRequestDTO;
import ar.com.mercadolibre.test.model.dto.response.MessageResponse;
import ar.com.mercadolibre.test.model.dto.response.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestService {

    Long create(TestCaseRequestDTO dto);

    TestCaseResponseDTO getById(Long id);

    List<TestCaseResponseDTO> getAll();

    TestCaseResponseDTO update(Long id, TestCaseRequestDTO dto);

    List<TestCaseResponseDTO> getAfterDate(LocalDate date);

    MessageResponse delete(Long id);
}
