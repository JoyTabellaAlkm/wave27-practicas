package ar.com.mercadolibre.tester.service;

import ar.com.mercadolibre.tester.dto.TestCreateDTO;
import ar.com.mercadolibre.tester.dto.TestListDTO;
import ar.com.mercadolibre.tester.entity.TestCase;
import ar.com.mercadolibre.tester.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final ITestRepository testRepository;

    public TestServiceImpl(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public TestCreateDTO createTest(TestCase testCase){
        testRepository.save(testCase);
        return new TestCreateDTO("Test Case creado con éxito!");
    }

    @Override
    public List<TestListDTO> getAllTest(){
        List<TestCase> testCase = testRepository.findAll();
        return testCase.stream()
                .map(testCase1 -> modelMapper.map(testCase1, TestListDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestListDTO getTest(Long id){
        Optional<TestCase> testCase = testRepository.findById(id);
        TestCase testCase1 = modelMapper.map(testCase, TestCase.class);
        return modelMapper.map(testCase1, TestListDTO.class);
    }

    @Override
    public TestCreateDTO updateTest(TestCase testCase){
        testRepository.save(testCase);
        return new TestCreateDTO("Test Case actualizado con éxito!");
    }

    @Override
    public TestCase findById(Long id){
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public TestCreateDTO deleteTest(Long id){
        testRepository.deleteById(id);
        return new TestCreateDTO("Test Case eliminado con éxito!");
    }

    @Override
    public List<TestListDTO> getAllTestDate(LocalDate lastUpdate){
        List<TestCase> testCases = testRepository.getTestCaseByLastUpdateAfter(lastUpdate);
        return testCases.stream()
                .map(testCase -> modelMapper.map(testCase, TestListDTO.class))
                .collect(Collectors.toList());
    }

}
