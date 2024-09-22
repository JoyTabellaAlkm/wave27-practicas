package org.mercadolibre.ageofperson.service;

import java.time.LocalDate;

public interface IAgeService {
    int getAge(int day, int month, int year);
}
