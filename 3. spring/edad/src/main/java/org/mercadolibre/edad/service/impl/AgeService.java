package org.mercadolibre.edad.service.impl;

import org.mercadolibre.edad.service.IAgeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgeService implements IAgeService {

    public int getAge(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.until(LocalDate.now()).getYears();
    }
}
