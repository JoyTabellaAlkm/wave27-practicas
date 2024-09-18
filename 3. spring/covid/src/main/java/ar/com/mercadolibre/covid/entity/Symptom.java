package ar.com.mercadolibre.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
public class Symptom {
    private UUID code;
    @Getter
    private String name;
    @Getter
    private int severity;
}
