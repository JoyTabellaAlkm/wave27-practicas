package ar.com.pruebadesaludo.saludo.service.impl;

import ar.com.pruebadesaludo.saludo.service.ISaludo;
import org.springframework.stereotype.Service;

@Service
public class SaludoService implements ISaludo {

    @Override
    public String sayHello(String name) {
        return "Hola desde el service\n"+ name;
    }
}
