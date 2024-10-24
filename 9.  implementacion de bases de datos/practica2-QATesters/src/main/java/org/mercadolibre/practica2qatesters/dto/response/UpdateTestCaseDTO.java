package org.mercadolibre.practica2qatesters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTestCaseDTO {
    private String menssage;
    private HttpStatus status;
    private TestCaseResponseDTO testCase;
}
