package ar.com.mercadolibre.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SymptomDto {
    private String name;
    private int severityLevel;
}