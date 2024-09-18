package org.mercadolibre.edad.component;

import org.springframework.stereotype.Component;

@Component
public class DateValidator {
    public String validate(int day, int month, int year){
        StringBuilder message = new StringBuilder();

        if (day < 1 || day > 31){
            message.append("El dia debe ser de 1 a 31\n");
        }

        if (month < 1 || month >12){
            message.append("El mes debe ser mayor a 1 o menor a 12\n");
        }

        if (year < 0){
            message.append("El año debe ser mayor a 0\n");
        }

        return message.toString();
    }

}
