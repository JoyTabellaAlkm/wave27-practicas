package com.mercadolibre.qatester.service.impl;


import com.mercadolibre.qatester.dto.ResponseDTO;
import com.mercadolibre.qatester.dto.request.TestCaseRequestDTO;
import com.mercadolibre.qatester.dto.response.TestCaseResponseDTO;
import com.mercadolibre.qatester.enitity.TestCase;
import com.mercadolibre.qatester.exception.NotFoundException;
import com.mercadolibre.qatester.repository.ITestCaseRepository;
import com.mercadolibre.qatester.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    private ITestCaseRepository testCaseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCaseRepo.save(testCase);
        TestCaseResponseDTO testCaseResponse = modelMapper.map(testCase, TestCaseResponseDTO.class);
        return testCaseResponse;
    }

    @Override
    public List<TestCaseResponseDTO> findAllTestCase(String lastUpdate) {
        if (lastUpdate == null) {
            return testCaseRepo.findAll().stream()
                    .map(test -> modelMapper.map(test, TestCaseResponseDTO.class))
                    .toList();
        }

        LocalDate lastUpdate2localDate = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return testCaseRepo.findTestCaseByLastUpdate(lastUpdate2localDate).stream()
                .map(test -> modelMapper.map(test, TestCaseResponseDTO.class))
                .toList();

    }

    @Override
    public TestCaseResponseDTO findByIdTestCase(Long id) {
        TestCase testCase = testCaseRepo.findById(id).orElseThrow(()-> new NotFoundException("No se encontro el caso de prueba con el id " + id + "."));
        if (testCase == null) {
            throw new NotFoundException("No se encontro el caso de prueba con el id " + id + ".");
        }
        TestCaseResponseDTO testCaseResponse = modelMapper.map(testCase, TestCaseResponseDTO.class);
        return testCaseResponse;
    }

    @Override
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testUpdated) {
        TestCase testCase = testCaseRepo.findById(id).orElseThrow(()-> new NotFoundException("No se encontro el caso de prueba con el id " + id + "."));

        testCase = modelMapper.map(testUpdated, TestCase.class);
        testCase.setIdCase(id);
        testCaseRepo.save(testCase);
        TestCaseResponseDTO testCaseResponseDTO = modelMapper.map(testCase, TestCaseResponseDTO.class);
        return testCaseResponseDTO;
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        testCaseRepo.findById(id).orElseThrow(()->new NotFoundException("No se encontro el caso de prueba con el id " + id + "."));

        testCaseRepo.deleteById(id);
        return new ResponseDTO("Caso de prueba " + id + " eliminado exitosamente", HttpStatus.OK);
    }


}
