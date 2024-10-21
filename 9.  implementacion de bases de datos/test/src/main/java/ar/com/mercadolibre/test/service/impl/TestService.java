package ar.com.mercadolibre.test.service.impl;

import ar.com.mercadolibre.test.model.dto.response.MessageResponse;
import ar.com.mercadolibre.test.repository.TestRepository;
import ar.com.mercadolibre.test.exception.NotFoundException;
import ar.com.mercadolibre.test.model.TestCase;
import ar.com.mercadolibre.test.model.dto.request.TestCaseRequestDTO;
import ar.com.mercadolibre.test.model.dto.response.TestCaseResponseDTO;
import ar.com.mercadolibre.test.service.ITestService;
import ar.com.mercadolibre.test.util.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService implements ITestService {


    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Long create(TestCaseRequestDTO dto) {

        TestCase toSave = Utils.changeDtoToEntity(dto, TestCase.class);
        TestCase saved = testRepository.save(toSave);
        return saved.getIdCase();
    }

    @Override
    public TestCaseResponseDTO getById(Long id) {
        TestCase find = testRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no Test Case with ID: " + id.toString()));
        TestCaseResponseDTO response = Utils.changeEntityToDTO(find, TestCaseResponseDTO.class);
        return response;
    }

    @Override
    public List<TestCaseResponseDTO> getAll() {
        return testRepository.findAll()
                .stream().map(testCase ->  Utils.changeEntityToDTO(testCase, TestCaseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseResponseDTO update(Long id, TestCaseRequestDTO dto) {
        TestCase toUpdate = Utils.changeDtoToEntity(dto, TestCase.class);
        TestCase model = testRepository.findById(id).orElseThrow(()-> new NotFoundException("There is no Test Case with ID: " + id.toString()));
        model.update(toUpdate);

        TestCase response = testRepository.save(model);

        return Utils.changeEntityToDTO(response, TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> getAfterDate(LocalDate date) {
        List<TestCaseResponseDTO> response = testRepository.getTestCasesByLastUpdateAfter(date)
                .stream().map(testCase -> Utils.changeEntityToDTO(testCase, TestCaseResponseDTO.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public MessageResponse delete(Long id) {
        testRepository.deleteById(id);
        return new MessageResponse("Eliminado correctamente!");
    }


}
