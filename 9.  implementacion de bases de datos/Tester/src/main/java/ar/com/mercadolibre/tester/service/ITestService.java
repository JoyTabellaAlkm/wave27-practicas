package ar.com.mercadolibre.tester.service;

import ar.com.mercadolibre.tester.dto.TestCreateDTO;
import ar.com.mercadolibre.tester.dto.TestListDTO;
import ar.com.mercadolibre.tester.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestService {

    TestCreateDTO createTest(TestCase testCase);
    List<TestListDTO> getAllTest();
    TestListDTO getTest(Long id);
    TestCreateDTO updateTest(TestCase testCase);
    TestCase findById(Long id);
    TestCreateDTO deleteTest(Long id);
    List<TestListDTO> getAllTestDate(LocalDate lastUpdate);
}
