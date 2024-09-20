package Clases;

import Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}
