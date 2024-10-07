package ar.com.mercadolibre.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Symptom {
    private int id;
    private String name;
    private int severityLevel;
}
