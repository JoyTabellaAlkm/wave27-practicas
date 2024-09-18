package ar.com.mercadolibre.dto.age.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeServiceImpl implements IAgeService{



    public Integer calculateAge(Integer day, Integer month, Integer year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        
        return Period.between(birthDate, currentDate).getYears();
    }
}
