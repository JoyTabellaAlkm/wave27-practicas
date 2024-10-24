package org.mercadolibre.practica2qatesters.service.impl;

import org.mercadolibre.practica2qatesters.config.exception.NotFoundException;
import org.mercadolibre.practica2qatesters.dto.request.TestCaseRequestDTO;
import org.mercadolibre.practica2qatesters.dto.response.ResponseDTO;
import org.mercadolibre.practica2qatesters.dto.response.TestCaseResponseDTO;
import org.mercadolibre.practica2qatesters.dto.response.UpdateTestCaseDTO;
import org.mercadolibre.practica2qatesters.entity.TestCase;
import org.mercadolibre.practica2qatesters.repository.ITestCaseRepository;
import org.mercadolibre.practica2qatesters.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository iTestCaseRepository;
    ModelMapper mapper = new ModelMapper();

    public TestCaseService(ITestCaseRepository iTestCaseRepository) {
        this.iTestCaseRepository = iTestCaseRepository;
    }

    @Override
    public ResponseDTO createTestCase(TestCaseRequestDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        iTestCaseRepository.save(testCase);

        return new ResponseDTO("The test with id: %d, has been created successfully".formatted(testCase.getId()), HttpStatus.CREATED);
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCase() {
        List<TestCaseResponseDTO> testDTO = iTestCaseRepository.findAll()
                .stream()
                .map(t -> mapper.map(t, TestCaseResponseDTO.class)).toList();

        return testDTO;
    }

    @Override
    public TestCaseResponseDTO getTestCaseById(Long id) {
        TestCase testCase = iTestCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("The test with the id: %d was not found".formatted(id)));
        TestCaseResponseDTO testDTO = mapper.map(testCase, TestCaseResponseDTO.class);

        return testDTO;
    }

    @Override
    public UpdateTestCaseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        this.getTestCaseById(id);

        TestCase testCase = mapper.map(testCaseRequestDTO, TestCase.class);
        testCase.setId(id);
        iTestCaseRepository.save(testCase);

        return new UpdateTestCaseDTO(
                "The test with the id: %d, was successfully updated".formatted(testCase.getId()),
                HttpStatus.OK,
                mapper.map(testCase, TestCaseResponseDTO.class));
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        this.getTestCaseById(id);

        iTestCaseRepository.deleteById(id);

        return new ResponseDTO("The jewel with id: %d, was successfully removed".formatted(id), HttpStatus.OK);
    }

    @Override
    public List<TestCaseResponseDTO> getTestCaseByDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<TestCase> testCaseList = iTestCaseRepository.findBylastUpdateGreaterThanEqual(localDate);

        List<TestCaseResponseDTO> testListDTO = Collections.singletonList(mapper.map(testCaseList, TestCaseResponseDTO.class));

        return testListDTO;
    }
}
