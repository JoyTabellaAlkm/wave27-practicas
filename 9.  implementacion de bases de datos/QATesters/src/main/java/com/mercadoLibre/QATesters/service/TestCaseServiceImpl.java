package com.mercadoLibre.QATesters.service;

import com.mercadoLibre.QATesters.config.exceptions.NotFoundException;
import com.mercadoLibre.QATesters.dto.ResponseDTO;
import com.mercadoLibre.QATesters.dto.TestCaseRequestDTO;
import com.mercadoLibre.QATesters.dto.TestCaseResponseDTO;
import com.mercadoLibre.QATesters.entity.TestCase;
import com.mercadoLibre.QATesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ITestCaseRepository testCaseRepository;

    @Override
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        TestCase savedTestCase = testCaseRepository.save(testCase);
        return modelMapper.map(savedTestCase, TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> getTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        List<TestCaseResponseDTO> testCaseResponseDTOs = new ArrayList<>();
        testCases.forEach(testCaseResponseDTO -> testCaseResponseDTOs.add(modelMapper.map(testCaseResponseDTO, TestCaseResponseDTO.class)));
        return testCaseResponseDTOs;
    }

    @Override
    public TestCaseResponseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró el Test Case"));
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    public ResponseDTO updateTestCase(TestCaseRequestDTO testCaseRequestDTO, Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró el Test Case"));
        TestCase updatedTestCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCaseRepository.save(updatedTestCase);
        return new ResponseDTO(HttpStatus.ACCEPTED, "Test Case modificado exitosamente");
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró el Test Case"));
        testCaseRepository.delete(testCase);
        return new ResponseDTO(HttpStatus.ACCEPTED, "Test Case eliminado exitosamente");
    }

    @Override
    public List<TestCaseResponseDTO> getTestCasesByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        List<TestCase> testCases = testCaseRepository.findByLastUpdateAfter(localDate);
        List<TestCaseResponseDTO> testCaseResponseDTOs = new ArrayList<>();
        testCases.forEach(testCaseResponseDTO -> testCaseResponseDTOs.add(modelMapper.map(testCaseResponseDTO, TestCaseResponseDTO.class)));
        return testCaseResponseDTOs;
    }
}
