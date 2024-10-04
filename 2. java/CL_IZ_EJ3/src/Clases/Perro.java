package Clases;

import Interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}
