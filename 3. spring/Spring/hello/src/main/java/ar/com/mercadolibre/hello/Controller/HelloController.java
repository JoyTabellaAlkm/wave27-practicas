package ar.com.mercadolibre.hello.Controller;

import ar.com.mercadolibre.hello.services.ISaludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    ISaludo iSaludo;

    @GetMapping("/saludar")
    public String sayHello(){
        return iSaludo.sayHello();
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hola, " + name + " :)";
    }

    @GetMapping("/nombre/{name}")
    public String sayHello2(@PathVariable String name){
        return iSaludo.sayHello2(name);
    }
}
