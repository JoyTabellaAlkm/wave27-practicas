package ar.com.mercadolibre.dto.covid.model.dto;

import ar.com.mercadolibre.dto.covid.model.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RiskPersonDTO {
    private String name;
    private String lastname;
    private Integer age;
    private List<Symptom> symptomList;
}
