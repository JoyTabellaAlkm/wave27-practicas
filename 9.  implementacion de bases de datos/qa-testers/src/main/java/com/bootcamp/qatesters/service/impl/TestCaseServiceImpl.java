package com.bootcamp.qatesters.service.impl;

import com.bootcamp.qatesters.dto.CreateTestCaseDto;
import com.bootcamp.qatesters.dto.CreatedTestCaseDto;
import com.bootcamp.qatesters.dto.TestCaseDto;
import com.bootcamp.qatesters.entity.TestCase;
import com.bootcamp.qatesters.repository.TestCaseRepository;
import com.bootcamp.qatesters.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final TestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository, ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreatedTestCaseDto createTestCase(CreateTestCaseDto testCaseDto) {
        TestCase testCase = modelMapper.map(testCaseDto, TestCase.class);

        testCase.setLastUpdate(LocalDate.now());
        testCase.setNumberOfTries(0);
        testCase = testCaseRepository.save(testCase);

        return new CreatedTestCaseDto(testCase.getId());
    }

    @Override
    public List<TestCaseDto> getAllTestCases(String lastUpdated) {
        List<TestCase> testCases;
        testCases = lastUpdated == null || lastUpdated.isBlank()
            ? testCaseRepository.findAll()
            : testCaseRepository.findAllByLastUpdateAfter(LocalDate.parse(lastUpdated, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return testCases.stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDto.class))
                .toList();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found"));
        return modelMapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCase(Long id, CreateTestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found"));
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());

        testCase = testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public CreatedTestCaseDto deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
        return new CreatedTestCaseDto(id);
    }
}
