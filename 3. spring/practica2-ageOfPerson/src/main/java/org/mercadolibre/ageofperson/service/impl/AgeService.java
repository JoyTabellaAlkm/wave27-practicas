package org.mercadolibre.ageofperson.service.impl;

import org.mercadolibre.ageofperson.service.IAgeService;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class AgeService implements IAgeService {

    @Override
    public int getAge(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate actual = LocalDate.now();
        Period period = date.until(actual);
        return period.getYears();
    }
}
