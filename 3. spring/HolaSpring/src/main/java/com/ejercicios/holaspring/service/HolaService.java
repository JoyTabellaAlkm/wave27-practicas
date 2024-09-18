package com.ejercicios.holaspring.service;

import com.ejercicios.holaspring.service.IHolaService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service @Primary

public class HolaService implements IHolaService {
    @Override
    public String sayHello(String nombre) {

        return "Hola " + nombre;
    }
}
