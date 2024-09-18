package clases;

import interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne.");
    }

}
