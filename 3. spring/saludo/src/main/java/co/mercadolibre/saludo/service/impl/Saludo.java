package co.mercadolibre.saludo.service.impl;

import co.mercadolibre.saludo.service.ISaludo;
import org.springframework.stereotype.Service;

@Service
public class Saludo implements ISaludo {
    @Override
    public String saludar(String nombre, String apellido) {
        return "Hola que se dice "+nombre+" "+apellido;
    }
}
