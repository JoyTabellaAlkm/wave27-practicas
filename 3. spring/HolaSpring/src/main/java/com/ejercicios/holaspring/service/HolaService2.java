package com.ejercicios.holaspring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

public class HolaService2 implements IHolaService {
    @Override
    public String sayHello(String nombre) {

        return "Hola, esta es la implementación 2, " + nombre;
    }
}
