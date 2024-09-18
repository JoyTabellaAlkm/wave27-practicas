package co.com.mercadolibre.hello.services.impl;

import co.com.mercadolibre.hello.services.ISaludar;
import org.springframework.stereotype.Service;

@Service
public class SaludoService implements ISaludar {

    @Override
    public String sayHello(String name) {
        return "Hola "+name+" te saludo desde el servidor";
    }
}
