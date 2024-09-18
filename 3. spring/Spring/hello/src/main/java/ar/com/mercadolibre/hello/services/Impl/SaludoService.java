package ar.com.mercadolibre.hello.services.Impl;

import ar.com.mercadolibre.hello.services.ISaludo;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class SaludoService implements ISaludo {

    @Override
    public String sayHello(){
        String saludo = "Hola a todos desde el service!!!";
        return saludo.toUpperCase(Locale.ROOT);
    }

    @Override
    public String sayHello2(String name){
        String saludo = "Hola a todos desde el service!!!";
        String mayuscula = saludo.toUpperCase(Locale.ROOT);
        return mayuscula + " " + name;
    }
}
