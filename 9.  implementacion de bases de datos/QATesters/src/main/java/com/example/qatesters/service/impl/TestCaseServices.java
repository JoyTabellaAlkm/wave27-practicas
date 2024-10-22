package com.example.qatesters.service.impl;

import com.example.qatesters.dto.requestDto.TestCaseRequestDto;
import com.example.qatesters.dto.responseDTO.TestCaseResponseDto;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.excepciones.NoFoundException;
import com.example.qatesters.repository.ITestCaseRepository;
import com.example.qatesters.service.ITestCaseServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseServices implements ITestCaseServices {

    @Autowired
    ITestCaseRepository testCaseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TestCaseResponseDto createTestCase(TestCaseRequestDto testCaseRequestDto) {
        TestCase testCase = modelMapper.map(testCaseRequestDto, TestCase.class);
        testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public List<TestCaseResponseDto> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        List<TestCaseResponseDto> testCaseResponseDtos = new ArrayList<>();
        testCases.forEach(testCase ->
            testCaseResponseDtos.add(modelMapper.map(testCase, TestCaseResponseDto.class)));
        return testCaseResponseDtos;
    }

    @Override
    public TestCaseResponseDto getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(()-> new NoFoundException("no se encontro id"));
        return modelMapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public TestCaseResponseDto updateTestCase(Long id, TestCaseRequestDto testCaseRequestDto) {
        testCaseRepository.findById(id)
                .orElseThrow(()-> new NoFoundException("no se encontro id"));
        TestCase testCase  = modelMapper.map(testCaseRequestDto, TestCase.class);
        testCase.setIdCase(id);
        testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public TestCaseResponseDto deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(()-> new NoFoundException("no se encontro id"));
        if (testCase != null) {
            testCaseRepository.delete(testCase);
        }
        return modelMapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public List<TestCaseResponseDto> getAllByLastUpdateDateTestCase(String lastUpdateTestCase) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(lastUpdateTestCase, formatter);
        List<TestCase> testCase = testCaseRepository.findByLastUpdateAfter(localDate);
        List<TestCaseResponseDto> testCaseResponseDto = new ArrayList<>();
        testCase.forEach(test->
        testCaseResponseDto.add(modelMapper.map(test, TestCaseResponseDto.class)));
        return testCaseResponseDto;
    }
}
