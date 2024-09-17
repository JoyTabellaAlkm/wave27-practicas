package com.bootcamp.pruebaspring.helloWorld.impl;

import com.bootcamp.pruebaspring.helloWorld.IHelloWorld;
import org.springframework.stereotype.Service;

@Service
public class IHelloWorldWorldImpl implements IHelloWorld {
    @Override
    public String helloWorld() {
        return "Hello World!!";
    }

    @Override
    public String helloName(String name) {
        return "Hello " + name + ", Have a nice day!";
    }
}
