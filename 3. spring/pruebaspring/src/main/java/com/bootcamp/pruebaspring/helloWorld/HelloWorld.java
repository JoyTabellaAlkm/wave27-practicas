package com.bootcamp.pruebaspring.helloWorld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @Autowired
    IHelloWorld iSayHello;

    @GetMapping()
    public String helloWorld(){


        return iSayHello.helloWorld();
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name){
        return iSayHello.helloName(name);
    }
}
