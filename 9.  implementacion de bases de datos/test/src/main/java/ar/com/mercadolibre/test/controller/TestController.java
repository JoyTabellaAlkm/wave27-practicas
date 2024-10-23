package ar.com.mercadolibre.test.controller;

import ar.com.mercadolibre.test.model.TestCase;
import ar.com.mercadolibre.test.model.dto.request.TestCaseRequestDTO;
import ar.com.mercadolibre.test.model.dto.response.MessageResponse;
import ar.com.mercadolibre.test.model.dto.response.TestCaseResponseDTO;
import ar.com.mercadolibre.test.service.ITestService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestController {

    private final ITestService service;

    public TestController(ITestService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody TestCaseRequestDTO dto){
        Long response = service.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCase(@PathVariable Long id){
        TestCaseResponseDTO response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseResponseDTO>> getAll(){
        List<TestCaseResponseDTO> response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> update(@PathVariable Long id,
                                           @RequestBody TestCaseRequestDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseResponseDTO>> getAfterDate(@RequestParam(name = "last_update")
                                                                      @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        return ResponseEntity.ok(service.getAfterDate(date));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
