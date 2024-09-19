package ar.com.mercadolibre.dto.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private Integer severityLevel;
}
