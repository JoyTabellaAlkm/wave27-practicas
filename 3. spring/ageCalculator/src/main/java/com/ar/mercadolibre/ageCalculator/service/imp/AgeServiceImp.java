package com.ar.mercadolibre.ageCalculator.service.imp;

import com.ar.mercadolibre.ageCalculator.exception.UnbornPersonException;
import com.ar.mercadolibre.ageCalculator.service.AgeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class AgeServiceImp implements AgeService {

    @Override
    public int calculateAge(int day, int month, int year) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int age = 0;

        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();

            age = Period.between(birthDate, today).getYears();

            if (age < 1) {
                throw new UnbornPersonException("Esta persona no nació");
            }

        } catch (UnbornPersonException e) {
            System.out.println(e.getMessage());
        }

        return age;
    }
}
