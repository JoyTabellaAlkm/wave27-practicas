package com.example.demo.DTOs;

import com.example.demo.Entities.Sintoma;

import java.util.List;

public class FindSymptomsDTO {
    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    private List<Sintoma> sintomas;
}
