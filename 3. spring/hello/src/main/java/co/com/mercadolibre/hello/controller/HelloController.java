package co.com.mercadolibre.hello.controller;

import co.com.mercadolibre.hello.services.ISaludar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    ISaludar iSaludar;
    @GetMapping("saludar/{name}")
    public String soyHello(@PathVariable String name){
        return iSaludar.sayHello(name);
    }
    @GetMapping("saludar2")
    public String soyHello2(){
        return "Hola este es el segundo saludo";
    }
}
